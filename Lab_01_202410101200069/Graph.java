import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph{
    private int numVertices;
    private ArrayList<ArrayList<Integer>> adj_list;
    Graph(int numVertices){
        if (numVertices < 1){
            throw new IllegalArgumentException("Number of vertices must be at least 1");
        }
        this.numVertices = numVertices;          
        adj_list = new ArrayList<>();
            for(int i = 0; i < numVertices; i++){
                adj_list.add(new ArrayList<>());
        }
    }

    void addEdge(int v1, int v2){
        if (v1 < 0 || v2 < 0 || v1 >= numVertices || v2 >= numVertices){
            throw new IllegalArgumentException("Vertices must not be negative, out of bound.");
        }
        
        adj_list.get(v1).add(v2);
        adj_list.get(v2).add(v1);
    }

    public void bfs(int startVertex){
        boolean visited[] = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int current = queue.remove();
            System.out.print(current + " ");

            for(int neighbor:adj_list.get(current)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
