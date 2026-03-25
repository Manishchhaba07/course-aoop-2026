// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// public class Main {
//     public static void main(String[] args) {

//         System.out.println("Range Addition: ");
//         List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
//         NumberST<Integer> st = new NumberST<Integer>(list, ((a,b) -> (a + b)), 0);
//         st.build();
//         st.printTree();
//         st.update(2, 5);
//         st.printTree();

//         System.out.println("Sum of range: ");
//         System.out.println(st.query(2, 3));

//         System.out.println("Range Multiplication: ");
//         NumberST<Integer> st2 = new NumberST<Integer>(list, ((a,b) -> (a * b)), 1);
//         st2.printTree();

//         System.out.println("Product of Range: ");
//         System.out.println(st2.query(2, 3));

//         System.out.println("Range GCD: ");
//         NumberST<Integer> st3 = new NumberST<Integer>(list, ((a,b) -> gcd(a, b)), 0);
//         st3.printTree();

//         System.out.println("GCD of range: ");
//         System.out.println(st3.query(2, 3));

//         NumberST<Integer> st4 = new NumberST<Integer>(list, ((a,b)-> a < b ? a : b), Integer.MAX_VALUE);
//         st4.printTree();

//         System.out.println("Min Value At: ");
//         System.out.println(st3.query(2, 3));

//         NumberST<Integer> st5 = new NumberST<Integer>(list, ((a,b)-> a < b ? b : a), Integer.MIN_VALUE);
//         st5.printTree();

//         System.out.println("Max Value At: ");
//         System.out.println(st5.query(2, 3));

//         NumberST<Integer> st6 = new NumberST<Integer>(list, ((a,b) -> a + b), 0);
//         System.out.println("Update Using Unary Operator: ");
//         st6.update(2, x -> x * 2);
//         st6.printTree();

//     }

//     private static int gcd(int a, int b) {
//         return b == 0 ? a : gcd(b, a % b);
//     }

// }