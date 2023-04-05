package shortestpath;


import graph.IGraph;
import node.Node;

import java.util.List;
import java.util.Map;

public interface ShortestPath<T> {
    public List<Node<T>> shortestpath(IGraph<T> graph, Node<T> node1, Node<T> node2);
}
