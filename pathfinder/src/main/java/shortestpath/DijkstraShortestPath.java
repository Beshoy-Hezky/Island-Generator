package shortestpath;
import edge.Edge;
import graph.IGraph;
import node.Node;
import java.util.*;

public class DijkstraShortestPath<T> implements ShortestPath<T>{
    @Override
    public Map <Node<T>, Node<T>> shortestpath(IGraph<T> graph, Node<T> node1, Node<T> node2) {
        Map<Node<T>, Node<T>> path = new HashMap<>();
        Map<Node<T>, Double> cost = new HashMap<>();
        graph.getNodes().forEach(node->{
            path.put(node,null);
            cost.put(node, Double.MAX_VALUE);
        });

        path.put(node1 , node1);
        cost.put(node1, 0d);
        PriorityQueue<Map.Entry<Node<T>, Double>> queue = new PriorityQueue<>(Comparator.comparingDouble(Map.Entry::getValue));
        queue.add(Map.entry(node1, 0d));

        while(!queue.isEmpty()){
            Node<T> current = queue.remove().getKey();
            for(Edge<T> edge : graph.EdgesOf(current)){
                if(cost.get(current) + edge.getWeight() < cost.get(edge.getNode2())){     // check later if edge.getNode2 is correct
                    path.put(edge.getNode2() , current);
                    cost.put(edge.getNode2() , cost.get(current) + edge.getWeight());
                    queue.add(Map.entry(edge.getNode2(), cost.get(edge.getNode2())));

                }
            }
        }
        return path;
    }
}
