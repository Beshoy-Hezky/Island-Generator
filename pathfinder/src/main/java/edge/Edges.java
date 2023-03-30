package edge;

import node.Node;
import uniquelist.UniqueList;

public class Edges extends UniqueList<Edge> {

    /**
     *
     * @param node the node you want to check
     * @return true if the node is found in one of the edges
     */
    public boolean contains(Node node){
        for (Edge edge : this){
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
    public Edge EdgeContain(Node node){
        Edge answer = null;
        for (Edge edge : this){
            if (edge.getNode1().equals(node) || edge.getNode2().equals(node)){
                answer = edge;
            }
        }
        return answer;
    }

}

