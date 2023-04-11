package shortestpath;
import edge.Edge;
import graph.IGraph;
import node.Node;
import java.util.*;

//used inspiration from the pseudocode of SFWRENG2C03 slides 'part 4'
public class DijkstraShortestPath<T> implements ShortestPath<T> {
    @Override
    public List<Node<T>> shortestpath(IGraph<T> graph, Node<T> node1, Node<T> node2, boolean print) {
        if(!graph.getNodes().contains(node1)){
            throw new IllegalArgumentException("node 1 does not exist");
        }
        else if(!graph.getNodes().contains(node2)){
            throw new IllegalArgumentException("node 2 does not exist");
        }

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

        List<Node<T>> answer_path;
        // if there is no path between both nodes
        if(path.get(node2) == null || path.get(node1) == null){
            List<Node<T>> empty_answer= new ArrayList<>();
            return empty_answer;
        }
            answer_path = makelist(path, node1, node2);


        // print nodes if needed
        if(print){
            printNodes(answer_path);
        }

        return (answer_path);
    }


    /**
     * Helper function to convert the hashmap returned by Dijkstra's algorithm into a list of vertices
     * @param path the hashmap returned by Dijkstra's
     * @param start the starting node of the pathway you want to form
     * @param end the ending node of the pathway you want to form
     * @return
     */
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

    /**
     * optional function to help print the nodes nicely into terminal for the client/user
     * @param thelist list of nodes you want to print
     */
    private void printNodes(List<Node<T>> thelist){
        String string = "";
        for(Node<T> node : thelist){
            System.out.print(string);
            string = " --> ";
            node.printNode();
        }
    }

}
