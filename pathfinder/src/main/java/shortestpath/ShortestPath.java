package shortestpath;


import graph.IGraph;
import node.Node;

import java.util.List;

public interface ShortestPath<T> {
    /**
     *
     * @param graph the graph passed in
     * @param node1 from this node
     * @param node2 to this node
     * @param print set to true if you want to print
     * @return
     */
    public List<Node<T>> shortestpath(IGraph<T> graph, Node<T> node1, Node<T> node2, boolean print);
}
