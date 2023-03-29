package graph;
import edge.Edge;
import edge.Edges;
import node.Node;
import java.util.HashMap;
import java.util.Map;

public abstract class AbGraph implements IGraph {
//public abstract class AbGraph {
    Map<Node, Edges> graph = new HashMap<>();

    public Edges EdgesOf(Node node) {
        if(!graph.containsKey(node)){
            throw new IllegalArgumentException("this node does not exist");
        }
        return graph.get(node);

    }

    public void AddNode(Node node){
        if(graph.containsKey(node)){
            throw new IllegalArgumentException("this node already exist");
        }
        graph.put(node , null);
    }

}

