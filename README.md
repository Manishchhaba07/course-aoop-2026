# Advanced OOPS Lab_01 – BFS Implementation

## Files Overview

### BFSTest.java
Driver class that creates a Graph instance and demonstrates Breadth-First Search (BFS) traversal to verify correctness and traversal order.

### Graph.java
Encapsulated graph implementation using an adjacency list. Includes `addEdge()` and a queue-based BFS algorithm with proper visited tracking.

### Conceptual_Questions.txt
Contains theoretical explanations covering BFS design decisions, queue vs stack behavior (BFS vs DFS), cycle handling, directed graph considerations, encapsulation examples, and time/space complexity analysis (O(V + E)).

# Advanced OOPS Lab_02 – DFS Implementation

## ✈️ Travel Planner using Graph Data Structure

This project is a Java-based travel planning system that models cities and their connections using graph data structures. It demonstrates the practical application of graph traversal algorithms—**Depth-First Search (DFS)** and **Breadth-First Search (BFS)**—to find routes between cities.

## 📌 Overview

The system represents each city as an immutable object and builds an undirected graph where cities are nodes and connections represent direct travel routes. It allows users to:

- Add cities and connections  
- Explore possible travel paths  
- Compare DFS and BFS traversal strategies  

---

## 🧩 Key Components

### 1. City Class
- Immutable design ensures data consistency and thread safety  
- Stores essential attributes: name, country, and timezone  
- Overrides `equals()` and `hashCode()` for reliable usage in collections  

### 2. TravelGraph Class
- Implements an adjacency list using `Map<City, List<City>>`  
- Supports:
  - Adding cities  
  - Creating bidirectional connections  
  - Pathfinding using DFS and BFS  

### 3. Pathfinding Algorithms

#### DFS (Depth-First Search)
- Explores paths deeply before backtracking  
- Implemented using a stack  
- Does not guarantee the shortest path  

#### BFS (Breadth-First Search)
- Explores level-by-level  
- Implemented using a queue  
- Guarantees the shortest path (in terms of number of connections)  

## 🧪 Testing

The `TravelPlannerTest` class demonstrates:
- Creation of multiple international cities  
- Establishment of travel routes  
- Execution of both DFS and BFS pathfinding  
- Output comparison of different traversal strategies  

## 💡 Key Concepts Demonstrated

- Graph representation using adjacency lists  
- DFS vs BFS traversal strategies  
- Immutability and its advantages  
- Encapsulation and input validation  
- Use of Java Collections Framework (`Map`, `List`, `Set`, `Stack`, `Queue`)  


## 🌍 Real-World Relevance

This project simulates a simplified travel or flight routing system. It can be extended by incorporating:
- Travel cost and duration  
- Flight schedules and airlines  
- Layover constraints and optimization strategies  

## 🚀 Conclusion

The project provides a strong foundation in graph-based problem solving and demonstrates how classical algorithms like DFS and BFS can be applied to real-world scenarios such as route planning and navigation systems.
