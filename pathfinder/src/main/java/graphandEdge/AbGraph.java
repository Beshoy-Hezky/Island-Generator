package graphandEdge;
import node.Node;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbGraph<T> implements IGraph<T> {
    protected Map<Node<T>, Edges<T>> graph = new HashMap<>();

    public Set<Node<T>> getNodes() {
        Set<Node<T>> allnodes = new HashSet<>();
        for(Node<T> node : graph.keySet()){
            allnodes.add(node);
        }
        return allnodes;
    }

    public Edges<T> EdgesOf(Node<T> node) {
        if(!graph.containsKey(node)){
            throw new IllegalArgumentException("this node does not exist");
        }
        return graph.get(node);

    }

    @Override
    public Node<T> AddNode(Node<T> node){
        if(graph.containsKey(node)){
            return node;
        }
        graph.put(node , new Edges<T>());
        return node;
    }

}

