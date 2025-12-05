package org.datastructures.graphs;

import java.util.ArrayList;

public class GraphAdjacencyList {

    static class GraphNode {
        private String name;
        private int index;
        private ArrayList<GraphNode> neighbors = new ArrayList<>();

        public GraphNode(String name, int index){
            this.name = name;
            this.index = index;
        }
    }

    static class Graph {

        ArrayList<GraphNode> nodeList;

        public Graph(ArrayList<GraphNode> nodeList){
            this.nodeList = nodeList;
        }

        public void addUndirectedEdge(int i, int j){
            GraphNode first = this.nodeList.get(i);
            GraphNode second = this.nodeList.get(j);
            first.neighbors.add(second);
            second.neighbors.add(first);
        }

        public String toString() {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < nodeList.size(); i++) {
                s.append(nodeList.get(i).name + ": ");
                for (int j =0; j < nodeList.get(i).neighbors.size(); j++) {
                    if (j == nodeList.get(i).neighbors.size()-1 ) {
                        s.append((nodeList.get(i).neighbors.get(j).name) );
                    } else {
                        s.append((nodeList.get(i).neighbors.get(j).name) + " -> ");
                    }
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

        System.out.println(newGraph);

    }


}
