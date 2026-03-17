import java.util.*;

public class TravelGraph {
    private final Map<City, List<City>> adj_list;

    public TravelGraph(){
        adj_list = new HashMap<>();
    }
    
    public void addCity(City city){
        if (city == null){
            throw new IllegalArgumentException("City cannot be null");
        }
        if(!adj_list.containsKey(city)){
            adj_list.put(city, new ArrayList<>());
        }
    }

    public void addConnection(City c1, City c2){
        if (c1 == null || c2 == null) {
            throw new IllegalArgumentException("Cities cannot be null.");
        }

        if (!adj_list.containsKey(c1) || !adj_list.containsKey(c2)) {
            throw new IllegalArgumentException("Both cities must exist in the graph.");
        }

        if (!adj_list.get(c1).contains(c2)) {
            adj_list.get(c1).add(c2);
        }

        if (!adj_list.get(c2).contains(c1)) {
            adj_list.get(c2).add(c1);
        }
    }

    public List<City> findPath(City start, City destination){
        if (start == null || destination == null || !adj_list.containsKey(start)){
            throw new IllegalArgumentException("City and destination should not be empty.");
        }

        if (!adj_list.containsKey(start)) {
            throw new IllegalArgumentException("Start city does not exist in the graph: " + start.getName());
        }

        if (!adj_list.containsKey(destination)) {
            throw new IllegalArgumentException("Destination city does not exist in the graph: " + destination.getName());
        }

        Stack<City> stack = new Stack<>();
        Set<City> visited = new HashSet<>();
        Map<City,City> parentMap = new HashMap<>();

        stack.push(start);
        parentMap.put(start, null);

        while (!stack.isEmpty()) {
            City current = stack.pop();

            if (visited.contains(current)) {
                continue;   
            }
            visited.add(current);

            if (current.equals(destination)) {
                List<City> path = new ArrayList<>();
                City step = destination;
                while (step != null) {
                    path.add(step);
                    step = parentMap.get(step);
                }
                Collections.reverse(path);
                return path;
            }

            for (City neighbour : adj_list.get(current)) {
                if (!visited.contains(neighbour)) {
                    stack.push(neighbour);
                    if (!parentMap.containsKey(neighbour)) {
                        parentMap.put(neighbour, current);
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    public List<City> findPathBFS(City start, City destination) {
        if (start == null || destination == null) {
            throw new IllegalArgumentException("Start and destination cities must not be null.");
        }
        if (!adj_list.containsKey(start)) {
            throw new IllegalArgumentException("Start city does not exist in the graph: " + start.getName());
        }
        if (!adj_list.containsKey(destination)) {
            throw new IllegalArgumentException("Destination city does not exist in the graph: " + destination.getName());
        }
 
        Queue<City>     queue     = new LinkedList<>();
        Set<City>       visited   = new HashSet<>();
        Map<City, City> parentMap = new HashMap<>();
 
        queue.add(start);
        visited.add(start);
        parentMap.put(start, null);
 
        while (!queue.isEmpty()) {
            City current = queue.poll();
 
            if (current.equals(destination)) {
                List<City> path = new ArrayList<>();
                City step = destination;
                while (step != null) {
                    path.add(step);
                    step = parentMap.get(step);
                }
                Collections.reverse(path);
                return path;
            }
 
            for (City neighbour : adj_list.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    parentMap.put(neighbour, current);
                    queue.add(neighbour);
                }
            }
        }
 
        return new ArrayList<>(); 
    }
}
