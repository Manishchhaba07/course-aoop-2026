import java.util.List;

public class TravelPlannerTest {
    private static void printPath(String label, List<City> path) {
        System.out.print(label + ": ");
        if (path.isEmpty()) {
            System.out.println("No path found.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i).getName());
                if (i < path.size() - 1) sb.append(" -> ");
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        City newYork   = new City("New York","USA","EDT");
        City london    = new City("London","UK","BST");
        City paris     = new City("Paris","France","CET");
        City tokyo     = new City("Tokyo","Japan","JST");
        City singapore = new City("Singapore","Singapore","SGT");
        City dubai     = new City("Dubai","UAE","GST");
        City sydney    = new City("Sydney","Australia","AEST");
        City mumbai    = new City("Mumbai","India","IST");

        TravelGraph graph = new TravelGraph();

        graph.addCity(newYork);
        graph.addCity(london);
        graph.addCity(paris);
        graph.addCity(tokyo);
        graph.addCity(singapore);
        graph.addCity(dubai);
        graph.addCity(sydney);
        graph.addCity(mumbai);

        graph.addConnection(newYork,   london);
        graph.addConnection(london,    paris);
        graph.addConnection(newYork,   tokyo);
        graph.addConnection(paris,     dubai);
        graph.addConnection(tokyo,     singapore);
        graph.addConnection(singapore, dubai);
        graph.addConnection(singapore, sydney);
        graph.addConnection(dubai,     mumbai);
        graph.addConnection(sydney,    mumbai);

        printPath("New York  -> Dubai  (DFS)", graph.findPath(newYork,   dubai));

        printPath("New York  -> Dubai  (BFS)", graph.findPathBFS(newYork,   dubai));
    }
}
