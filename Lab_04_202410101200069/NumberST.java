import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class NumberST<T extends Number> {
    
    private List<T> data;
    private int n;
    private int paddedSize;
    private List<T> STArray;
    T identity;
    BinaryOperator<T> mergefunc;

    public NumberST(List<T> data, BinaryOperator<T> mergefunc, T identity){
        this.data = data;
        this.n = data.size();
        this.paddedSize = getNextPowerOfTwo(n);
        this.STArray = new ArrayList<>(Collections.nCopies(2 * paddedSize, identity));
        this.mergefunc = mergefunc;
        this.identity = identity;
        build();
    }


    int getNextPowerOfTwo(int n){
        int power = 1;
        while(power < n){
            power *= 2;
        }
        return power;
    }

    void build() {

        for (int i = 0; i < n; i++) {
            STArray.set(paddedSize + i, data.get(i));
        }

        for (int i = paddedSize - 1; i > 0; i--) {
            STArray.set(i, mergefunc.apply(STArray.get(2 * i), STArray.get(2 * i + 1)));
        }
    }

    void update(int index, T value){
        this.data.set(index, value);
        int setIndex = index + paddedSize;
        STArray.set(setIndex, value);

        int current = setIndex;

        while (current > 1) {
            current /= 2;
            STArray.set(current, mergefunc.apply(STArray.get(2 * current), STArray.get(2 * current + 1)));
        }
    }

    void printTree(){
        for(int i = 1; i < STArray.size(); i++){
            System.out.print(STArray.get(i) + " ");
        }
        System.out.println();
    }
    
    private T queryHelper(int l, int r, int start, int end, int node){
        if (r < start || end < l) {
            return identity;
        }

        if (l <= start && end <= r) {
            return STArray.get(node);
        }

        int mid = start + (end - start) / 2;
        int leftChild = 2 * node;
        int rightChild = 2 * node + 1;

        return mergefunc.apply(queryHelper(l, r, start, mid, leftChild), queryHelper(l, r, mid + 1, end, rightChild));
    }

    public T query(int left, int right){
        return queryHelper(left, right, 0, n - 1, 1);
    }

    void update(int index, UnaryOperator<T> fn){
        T oldValue = data.get(index);
        T newValue = fn.apply(oldValue);
        update(index, newValue);
    }

    public static void main(String[] args) {

        System.out.println("Range Addition: ");
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        NumberST<Integer> st = new NumberST<Integer>(list, ((a,b) -> (a + b)), 0);
        st.build();
        st.printTree();
        st.update(2, 5);
        st.printTree();

        System.out.println("Sum of range: ");
        System.out.println(st.query(2, 3));

        System.out.println("Range Multiplication: ");
        NumberST<Integer> st2 = new NumberST<Integer>(list, ((a,b) -> (a * b)), 1);
        st2.printTree();

        System.out.println("Product of Range: ");
        System.out.println(st2.query(2, 3));

        System.out.println("Range GCD: ");
        NumberST<Integer> st3 = new NumberST<Integer>(list, ((a,b) -> gcd(a, b)), 0);
        st3.printTree();

        System.out.println("GCD of range: ");
        System.out.println(st3.query(2, 3));

        NumberST<Integer> st4 = new NumberST<Integer>(list, ((a,b)-> a < b ? a : b), Integer.MAX_VALUE);
        st4.printTree();

        System.out.println("Min Value At: ");
        System.out.println(st3.query(2, 3));

        NumberST<Integer> st5 = new NumberST<Integer>(list, ((a,b)-> a < b ? b : a), Integer.MIN_VALUE);
        st5.printTree();

        System.out.println("Max Value At: ");
        System.out.println(st5.query(2, 3));

        NumberST<Integer> st6 = new NumberST<Integer>(list, ((a,b) -> a + b), 0);
        System.out.println("Update Using Unary Operator: ");
        st6.update(2, x -> x * 2);
        st6.printTree();

    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}