package graph;

import edge.Edges;
import node.Node;

import java.util.Set;

public interface IGraph<T> {

    Node<T> addNode(Node<T> node);

    Set<Node<T>> getNodes();

    Edges<T> EdgesOf(Node<T> node);

    public void addEdge(Node<T> node1, Node<T> node2, double weight);
}
