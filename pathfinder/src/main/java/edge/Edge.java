package edge;

import node.Node;

public class Edge {
    Node first;
    Node second;

    float weight;

    /**
     * @param node1 node where the edge is extending out
     * @param node2 node where the edge is extending to
     * @param weight weight of the edge
     */
    public Edge(Node node1, Node node2, float weight){
        this.first = node1;
        this.second = node2;
        this.weight = weight;
    }

    /**
     * @param node1 node where the edge is extending out
     * @param node2 node where the edge is extending to
     */
    public Edge(Node node1, Node node2){
        this.first = node1;
        this.second = node2;
        this.weight = 1.0f;
    }

    /**
     * @return the first node in a directed edge
     */
    public Node getNode1() {
        return first;
    }

    /**
     * @return the second node in a directed edge
     */
    public Node getNode2() {
        return second;
    }


}
