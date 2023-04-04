/*
package shortestpath;

import edge.Edge;
import edge.Edges;
import graph.IGraph;
import graph.UndirectedGraphs;
import node.Node;

import java.lang.reflect.Array;
import java.util.*;

public class DijkstraShortestPath<T> implements ShortestPath<T>{
    @Override
    public Map <Node<T>, Node<T>> shortestpath(IGraph<T> graph, Node<T> node1, Node<T> node2) {
        Map<Node, Node> path = new HashMap<>();
        Map<Node, Double> cost = new HashMap<>();
        graph.getNodes().forEach(node->{
            path.put(node,null);
            cost.put(node, Double.MAX_VALUE);
        });

        path.put(node1 , node1);
        cost.put(node1, 0d);
        PriorityQueue<Map.Entry<Node,Double>> queue = new PriorityQueue<>(Comparator.comparingDouble(Map.Entry::getValue));
        queue.add(Map.entry(node1, 0d));

        while(!queue.isEmpty()){
            Node<T> m = queue.remove().getKey();
            for()
        }




        return null;
    }




}

*/
