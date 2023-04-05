package graph;
import edge.Edge;
import edge.Edges;
import node.Node;


public class UndirectedGraphs<T> extends AbGraph<T> {

    /**
     * Adds the edge into existing node in both ways
     * @param node1 the first node
     * @param node2 the second node
     */
    public void AddEdge(Node<T> node1, Node<T> node2, double weight){
        if(!graph.containsKey(node1)){
           throw new IllegalArgumentException("node 1 does not exist");
        }
        else if(!graph.containsKey(node2)){
            throw new IllegalArgumentException("node 1 does not exist");
        }
        Edges<T> edges1 = graph.get(node1);
        Edges<T> edges2 = graph.get(node2);
        edges1.add(new Edge(node1, node2, weight));
        edges2.add(new Edge(node1, node2, weight));
    }

}
