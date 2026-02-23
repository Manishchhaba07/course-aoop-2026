public class BFSTest {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        // Example 1
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        
        g.bfs(0);

        // Example 2
        // g.addEdge(0, 1);
        // g.addEdge(1, 2);
        // g.addEdge(2, 3);
        // g.addEdge(3, 4);
        // g.bfs(2);

        // Example 3
        // g.addEdge(0, 1);
        // g.addEdge(0, 2);
        // g.addEdge(3, 5);
        // g.addEdge(3, 4);
        
        // g.bfs(0);
    }
}

