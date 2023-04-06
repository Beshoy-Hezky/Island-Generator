package shortestpath;
import graphandEdge.Edge;
import graphandEdge.IGraph;
import node.Node;
import java.util.*;

//used inspiration from pseudocode of SFWRENG2C03 slides part 4
public class DijkstraShortestPath<T> implements ShortestPath<T> {
    @Override
    public List<Node<T>> shortestpath(IGraph<T> graph, Node<T> node1, Node<T> node2) {
        Map<Node<T>, Node<T>> path = new HashMap<>();
        Map<Node<T>, Double> cost = new HashMap<>();
        graph.getNodes().forEach(node -> {
            path.put(node, null);
            cost.put(node, Double.MAX_VALUE);
        });

        path.put(node1, node1);
        cost.put(node1, 0d);
        PriorityQueue<Map.Entry<Node<T>, Double>> queue = new PriorityQueue<>(Comparator.comparingDouble(Map.Entry::getValue));
        queue.add(Map.entry(node1, 0d));

        while (!queue.isEmpty()) {
            Node<T> current = queue.remove().getKey();
            for (Edge<T> edge : graph.EdgesOf(current)) {
                if (cost.get(current) + edge.getWeight() < cost.get(edge.getNode2())) {
                    path.put(edge.getNode2(), current);
                    cost.put(edge.getNode2(), cost.get(current) + edge.getWeight());
                    queue.add(Map.entry(edge.getNode2(), cost.get(edge.getNode2())));

                }
            }
        }
        // if node is unreachable from start node return an empty array
        if(path.get(node2) == null){
            return (new ArrayList<Node <T>>());
        }
        return (makelist(path, node1, node2));
    }


    private List<Node<T>> makelist(Map<Node<T>, Node<T>> path, Node<T> start, Node<T> end) {
        List<Node<T>> answer = new ArrayList<>();
        Node<T> node = end;
        answer.add(node);

        do {
            node = path.get(node);
            answer.add(node);
        }
        while (node != start);

        Collections.reverse(answer);
        return answer;
    }

    /*for (Node<T> node : path.keySet()) {
        node.printNode();
        System.out.print("  :  ");
        if (path.get(node) != null) {
            path.get(node).printNode();
        } else {
            System.out.print("null");
        }
        System.out.println();
    }*/
}
