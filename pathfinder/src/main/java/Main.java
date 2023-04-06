import graphandEdge.UndirectedGraphs;
import node.Node;
import shortestpath.DijkstraShortestPath;
import shortestpath.ShortestPath;
import java.util.List;

public class Main {
   public static void main(String[] args) {
      UndirectedGraphs<Integer> graph = new UndirectedGraphs<>();
      ShortestPath<Integer> finder = new DijkstraShortestPath<>();

      Node<Integer> node0 = graph.AddNode(new Node<>(0));
      Node<Integer> node1 = graph.AddNode(new Node<>(1));
      Node<Integer> node2 = graph.AddNode(new Node<>(2));
      Node<Integer> node3 = graph.AddNode(new Node<>(3));
      Node<Integer> node4 = graph.AddNode(new Node<>(4));
      Node<Integer> node5 = graph.AddNode(new Node<>(5));
      Node<Integer> node6 = graph.AddNode(new Node<>(6));
      Node<Integer> node7 = graph.AddNode(new Node<>(7));
      Node<Integer> node8 = graph.AddNode(new Node<>(8));
      Node<Integer> node9 = graph.AddNode(new Node<>(9));
      Node<Integer> node12 = graph.AddNode(new Node<>(12));





      graph.AddEdge(node3,node8, 1);
      graph.AddEdge(node3,node0,9);
      graph.AddEdge(node3,node2,5);
      graph.AddEdge(node1,node5, 2);
      graph.AddEdge(node1,node8, 4);
      graph.AddEdge(node8,node5, 7);
      graph.AddEdge(node2,node7, 7);
      graph.AddEdge(node4,node0, 13);
      graph.AddEdge(node5,node9, 8);
      graph.AddEdge(node6,node5, 3);
      graph.AddEdge(node6,node9, 4);
      graph.AddEdge(node7,node0, 12);
      graph.AddEdge(node9,node0, 11);


      List<Node<Integer>> thelist = finder.shortestpath(graph, node3 ,node9);
      for(Node<Integer> node : thelist){
         node.printNode();
         System.out.println();
      }

   }
}