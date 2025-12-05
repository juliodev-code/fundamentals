package org.datastructures.graphs;

import java.util.ArrayList;

public class GraphAdjacencyMatrix {

    static class GraphNode {
        private String name;
        private int index;

        public GraphNode(String name, int index){
            this.name = name;
            this.index = index;
        }
    }

    private static class Graph {
        ArrayList<GraphNode> nodeList;
        int[][] adjacencyMatrix;

        public Graph(ArrayList<GraphNode> nodeList){
            this.nodeList = nodeList;
            this.adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
        }

        public void addUndirectedEdge(int i, int j){
            this.adjacencyMatrix[i][j] = 1;
            this.adjacencyMatrix[j][i] = 1;
        }

        public String toString() {
            StringBuilder s = new StringBuilder();
            s.append("   ");
            for (int i = 0; i < nodeList.size(); i++) {
                s.append(nodeList.get(i).name + " ");
            }
            s.append("\n");
            for (int i = 0; i < nodeList.size(); i++) {
                s.append(nodeList.get(i).name + ": ");
                for (int j : adjacencyMatrix[i]) {
                    s.append((j) + " ");
                }
                s.append("\n");
            }
            return s.toString();
        }
    }

    static void main() {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A",0));
        nodeList.add(new GraphNode("B",1));
        nodeList.add(new GraphNode("C",2));
        nodeList.add(new GraphNode("D",3));
        nodeList.add(new GraphNode("E",4));

        Graph newGraph = new Graph(nodeList);
        newGraph.addUndirectedEdge(0, 1);
        newGraph.addUndirectedEdge(0, 2);
        newGraph.addUndirectedEdge(0, 3);
        newGraph.addUndirectedEdge(1, 4);
        newGraph.addUndirectedEdge(2, 3);
        newGraph.addUndirectedEdge(3, 4);

        System.out.println(newGraph.toString());
    }
}
