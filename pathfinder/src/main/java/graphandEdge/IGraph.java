package graphandEdge;

import node.Node;

import java.util.Set;

public interface IGraph<T> {

    Node<T> AddNode(Node<T> node);

    Set<Node<T>> getNodes();

    Edges<T> EdgesOf(Node<T> node);
}
