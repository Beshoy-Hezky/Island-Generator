package graph;
import edge.Edges;
import node.Node;

public class DirectedGraph<T> extends AbGraph<T> implements IGraph<T>{

    /**
     * Adds the directed edge into existing node in one way
     * @param node1 the first node (edge from node 1)
     * @param node2 the second node (edge to node 2)
     */
    public void addEdge(Node<T> node1, Node<T> node2, double weight){
        if(!graph.containsKey(node1)){
            throw new IllegalArgumentException("node 1 does not exist");
        }
        else if(!graph.containsKey(node2)){
            throw new IllegalArgumentException("node 2 does not exist");
        }
        Edges<T> edges1 = graph.get(node1);
        edges1.addEdge(node1, node2, weight);
    }

}
