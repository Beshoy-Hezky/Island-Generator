package edge;

import node.Node;

public class Edge<T> {
    private final Node<T> first;
    private final Node<T> second;

    private final double weight;

    /**
     * protected so that no one can make an edge outside of this package
     * @param node1 node where the edge is extending out
     * @param node2 node where the edge is extending to
     * @param weight weight of the edge
     */
    protected Edge(Node<T> node1, Node<T> node2, double weight){
        this.first = node1;
        this.second = node2;
        this.weight = weight;
    }

    /**
     * protected so that no one can make an edge outside of this package
     * @param node1 node where the edge is extending out
     * @param node2 node where the edge is extending to
     */
    protected Edge(Node<T> node1, Node<T> node2){
        this.first = node1;
        this.second = node2;
        this.weight = 1.0d;
    }

    /**
     * @return the first node in a directed edge
     */
    public Node<T> getNode1() {
        return first;
    }

    /**
     * @return the second node in a directed edge
     */
    public Node<T> getNode2() {
        return second;
    }

    /**
     *
     * @return the weight of a double
     */
    public Double getWeight(){
        return this.weight;
    }
}
