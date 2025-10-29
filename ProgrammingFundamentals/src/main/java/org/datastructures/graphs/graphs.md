# Graphs

## What is a Graph?
A **graph** is a data structure that represents **connections** or **relationships** between items.  
Each item is called a **node** (or **vertex**), and the connections between them are called **edges**.

## Key Concepts
- **Vertex (Node):** Represents an entity (like a person, city, or webpage).
- **Edge:** Represents a connection between two vertices.
- **Directed Graph:** The edges have a direction (A → B).
- **Undirected Graph:** The edges don’t have direction (A — B).
- **Weighted Graph:** Each edge has a value (e.g., distance, cost).
- **Unweighted Graph:** All edges are considered equal.

## Types of Graphs
- **Simple Graph:** No loops or multiple edges between nodes.
- **Complete Graph:** Every node is connected to every other node.
- **Sparse/Dense Graph:** Few or many edges relative to the number of nodes.
- **Cyclic/Acyclic Graph:** Has cycles (paths that start and end at the same node) or not.

## Common Uses
- Social networks (friends connections)
- Maps and navigation (cities and routes)
- Web crawlers (pages and links)
- Network routing

## Common Operations
- Add or remove nodes and edges.
- Traverse (visit all nodes) using **BFS** (Breadth-First Search) or **DFS** (Depth-First Search).
- Find shortest paths (e.g., Dijkstra’s algorithm).
