package graph;
import edge.Edge;
import edge.Edges;
import node.Node;


public class UndirectedGraphs extends AbGraph {

    /**
     * Adds the edge into existing node in both ways
     * @param node1 the first node
     * @param node2 the second node
     */
    public void AddEdge(Node node1, Node node2){
        if(!graph.containsKey(node1)){
           throw new IllegalArgumentException("node 1 does not exist");
        }
        else if(!graph.containsKey(node2)){
            throw new IllegalArgumentException("node 1 does not exist");
        }
        Edges edges1 = graph.get(node1);
        Edges edges2 = graph.get(node2);
        edges1.add(new Edge(node1, node2));
        edges2.add(new Edge(node1, node2));
    }

}
