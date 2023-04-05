package graph;

import edge.Edges;
import node.Node;

import java.util.Set;

public interface IGraph<T> {

    void AddNode(Node<T> node);

    Set<Node<T>> getNodes();

    Edges<T> EdgesOf(Node<T> node);
}
