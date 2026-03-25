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


# Advanced OOPS Lab_04 – Generic Segment Tree 🌳

A flexible, generic **Segment Tree** implementation in Java that supports any numeric type and any binary operation — including sum, product, GCD, min, max, and custom functions.

---

## 🚀 Features

- ✅ Generic type support (`Integer`, `Long`, `Double`, etc.)
- ✅ Custom binary operations via `BinaryOperator<T>`
- ✅ Custom update logic via `UnaryOperator<T>`
- ✅ Supports **Range Sum**, **Range Product**, **Range GCD**, **Range Min**, **Range Max**
- ✅ Point updates in **O(log n)**
- ✅ Range queries in **O(log n)**
- ✅ Auto-pads to next power of two for efficient indexing

---

## 🧠 How It Works

The tree is built over a padded array (next power of 2). Leaf nodes store the original data, and internal nodes store the result of merging their children using the provided `BinaryOperator`.
```
Input:  [1, 2, 3, 4]

Sum Tree:
        10
       /    \
      3      7
     / \    / \
    1   2  3   4
```

---

## 🛠️ Usage

### 1. Range Sum
```java
List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
NumberST<Integer> st = new NumberST<>(list, (a, b) -> a + b, 0);
System.out.println(st.query(1, 3)); // Sum from index 1 to 3
```

### 2. Range Product
```java
NumberST<Integer> st = new NumberST<>(list, (a, b) -> a * b, 1);
System.out.println(st.query(0, 3)); // Product of all elements
```

### 3. Range GCD
```java
NumberST<Integer> st = new NumberST<>(list, (a, b) -> gcd(a, b), 0);
System.out.println(st.query(0, 3));
```

### 4. Range Min / Max
```java
// Min
NumberST<Integer> minST = new NumberST<>(list, (a, b) -> a < b ? a : b, Integer.MAX_VALUE);

// Max
NumberST<Integer> maxST = new NumberST<>(list, (a, b) -> a > b ? a : b, Integer.MIN_VALUE);
```

### 5. Point Update (Direct Value)
```java
st.update(2, 5); // Set index 2 to value 5
```

### 6. Point Update (Using UnaryOperator)
```java
st.update(2, x -> x * 2); // Double the value at index 2
```

---

## ⏱️ Time & Space Complexity

| Operation | Complexity |
|-----------|------------|
| Build     | O(n)       |
| Query     | O(log n)   |
| Update    | O(log n)   |
| Space     | O(n)       |

---

## 🔧 Constructor
```java
NumberST<T>(List<T> data, BinaryOperator<T> mergeFunc, T identity)
```

| Parameter    | Description                                      |
|--------------|--------------------------------------------------|
| `data`       | Input list of elements                           |
| `mergeFunc`  | Binary function to merge two nodes               |
| `identity`   | Identity value for the operation (e.g. `0` for sum, `1` for product) |

---

## 📌 Methods

| Method | Description |
|--------|-------------|
| `build()` | Builds the segment tree from input data |
| `query(int l, int r)` | Returns merged result for range `[l, r]` |
| `update(int index, T value)` | Updates element at index to new value |
| `update(int index, UnaryOperator<T> fn)` | Updates element using a function |
| `printTree()` | Prints all tree nodes |

---

## 📚 Concepts Used

- Segment Trees (Iterative + Recursive hybrid)
- Java Generics (`<T extends Number>`)
- Functional Interfaces (`BinaryOperator`, `UnaryOperator`)
- Power-of-two padding for tree alignment
