package shortestpath;


import graphandEdge.IGraph;
import node.Node;

import java.util.List;

public interface ShortestPath<T> {
    public List<Node<T>> shortestpath(IGraph<T> graph, Node<T> node1, Node<T> node2);
}
