package graph;

import node.Node;

import java.util.Set;

public interface IGraph<T> {

    public void AddNode(Node<T> node);

    public Set<Node<T>> getNodes();
}
