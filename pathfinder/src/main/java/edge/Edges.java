package edge;

import node.Node;
import datastructures.UniqueList;

public class Edges<T> extends UniqueList<Edge<T>> {

    /**
     *
     * @param node the node you want to check
     * @return true if the node is found in one of the edges
     */
    protected boolean contains(Node<T> node){
        for (Edge<T> edge : this){
            if (edge.getNode1().equals(node) || edge.getNode2().equals(node)){
                return true;
            }
        }
        return false;
    }

    /**
     * checks if this exact edge exists
     * @param node1 node 1 of the edge
     * @param node2 node 2 of the edge
     * @param weight weight of the edge
     * @return true if this exact edge exists
     */
    protected boolean EdgeContain(Node<T> node1, Node<T> node2, double weight){
        for (Edge<T> edge : this){
            if (edge.getNode1().equals(node1) && edge.getNode2().equals(node2) && edge.getWeight().equals(weight)){
                return true;
            }
        }
        return false;
    }

    /**
     * Edges can only be constructed through the edges array list and it will first check if it already contains it
     * @param node1 first node of the edge
     * @param node2 second node of the edge
     * @param weight weight of that edge
     */
    public void addEdge(Node<T> node1, Node<T> node2, double weight){
        if(!this.EdgeContain(node1, node2,weight)){
            this.add(new Edge<T>(node1, node2, weight));
        }
    }

}

