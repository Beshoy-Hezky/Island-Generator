package graph;
import edge.Edges;
import node.Node;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbGraph<T> implements IGraph<T> {
    protected Map<Node<T>, Edges<T>> graph = new HashMap<>();

    /**
     *
     * @return return a set of nodes of the graph
     */
    public Set<Node<T>> getNodes() {
        Set<Node<T>> allnodes = new HashSet<>();
        for(Node<T> node : graph.keySet()){
            allnodes.add(node);
        }
        return allnodes;
    }


    /**
     *
     * @param node the node that you want the edges connected to
     * @return the arraylist that stores the edges
     */
    public Edges<T> EdgesOf(Node<T> node) {
        if(!graph.containsKey(node)){
            throw new IllegalArgumentException("this node does not exist");
        }
        return graph.get(node);

    }

    @Override
    public Node<T> addNode(Node<T> node){
        if(graph.containsKey(node)){
            return node;
        }
        graph.put(node , new Edges<T>());
        return node;
    }

}

