package org.datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {

    public List<Integer> findOrder(int numNodes, int[][]edges){
        // 1. Initialize structures
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numNodes];
        for (int i = 0; i < numNodes; i++) {
            adj.add(new ArrayList<>());
        }

        // 2. Build the Graph
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            adj.get(parent).add(child);
            inDegree[child]++; // Track how many prerequisites each node has
        }

        // 3. Add nodes with 0 in-degree to the Queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numNodes; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> topoOrder = new ArrayList<>();

        // 4. Process the Queue
        while (!queue.isEmpty()) {
            int current = queue.poll();
            topoOrder.add(current);
            for (int neighbor : adj.get(current)) {
                inDegree[neighbor]--; // Remove the "dependency"

                // If all dependencies are met, add to queue
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // 5. Cycle Detection check
        if (topoOrder.size() != numNodes) {
            return new ArrayList<>(); // Return empty list if a cycle exists
        }

        return topoOrder;

    }


    public static void main(String[] args) {
        TopologicalSort solver = new TopologicalSort();
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        System.out.println("Topological Order: " + solver.findOrder(4, edges));
    }
}
