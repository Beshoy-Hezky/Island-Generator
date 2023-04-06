package graphandEdge;

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
     * function only called when contains returns true
     * @param node the node you want to check
     * @return the edge that contains the node
     */
    protected Edge<T> EdgeContain(Node<T> node){
        Edge<T> answer = null;
        for (Edge<T> edge : this){
            if (edge.getNode1().equals(node) || edge.getNode2().equals(node)){
                answer = edge;
            }
        }
        return answer;
    }

}

