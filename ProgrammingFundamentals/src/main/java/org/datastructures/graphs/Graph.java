package org.datastructures.graphs;

import java.util.*;

public class Graph {
    private Map<String, List<String>> adjList = new HashMap<>();

    //add a vertex
    public void addVertex(String vertex){
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    //add an edge
    public void addEdge(String v1, String v2){
        adjList.get(v1).add(v2);
        adjList.get(v2).add(v1);//remove this if the graph is directed
    }

    // Print the graph
    public void printGraph() {
        for (String vertex : adjList.keySet()) {
            System.out.println(vertex + " -> " + adjList.get(vertex));
        }
    }

    //Breadth-first search
    public void bfs(String start){
        Set<String> visited = new HashSet<>();
        java.util.Queue<String> queue = new java.util.LinkedList<>();

        queue.add(start);
        visited.add(start);

        System.out.print("BFS: ");
        while(!queue.isEmpty()){
            String vertex = queue.poll();
            System.out.print(vertex + " ");
            for(String neighbor: adjList.get(vertex)){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    //Depth-first search(DFS)
    public void dfs(String start){
        Set<String> visited = new HashSet<>();
        System.out.print("DFS:");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(String vertex, Set<String> visited){
        visited.add(vertex);
        System.out.print(vertex + " ");
        for(String neighbor: adjList.get(vertex)){
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    static void main(){
        Graph graph = new Graph();
        //adding vertex
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        //Add edges

        graph.addEdge("A", "B");
        graph.addEdge("A", "D");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");

        graph.printGraph();

        graph.dfs("C"); // Depth-first search
        graph.bfs("C"); // Breadth-first search
    }
}
