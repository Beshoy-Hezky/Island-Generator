package shortestpath;

import edge.Edges;
import graph.IGraph;
import node.Node;

import java.util.Map;

public interface ShortestPath<T> {
    public Map<Node<T> , Node<T>> shortestpath(IGraph<T> graph, Node<T> node1, Node<T> node2);
}
