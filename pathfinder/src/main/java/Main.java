import graph.UndirectedGraph;
import node.Node;
import shortestpath.DijkstraShortestPath;
import shortestpath.ShortestPath;
import java.util.List;

public class Main {
   public static void main(String[] args) {
      UndirectedGraph<Integer> graph = new UndirectedGraph<>();
      ShortestPath<Integer> finder = new DijkstraShortestPath<>();

      //This graph is from the class example from 2C03 class I will include a PNG file
      Node<Integer> node0 = graph.addNode(new Node<>(0));
      Node<Integer> node1 = graph.addNode(new Node<>(1));
      Node<Integer> node2 = graph.addNode(new Node<>(2));
      Node<Integer> node3 = graph.addNode(new Node<>(3));
      Node<Integer> node4 = graph.addNode(new Node<>(4));
      Node<Integer> node5 = graph.addNode(new Node<>(5));
      Node<Integer> node6 = graph.addNode(new Node<>(6));
      Node<Integer> node7 = graph.addNode(new Node<>(7));
      Node<Integer> node8 = graph.addNode(new Node<>(8));
      Node<Integer> node9 = graph.addNode(new Node<>(9));
      Node<Integer> node12 = graph.addNode(new Node<>(12));
      Node<Integer> node11 = graph.addNode(new Node<>(9));

      System.out.println(node11.equals(node9));

      graph.addEdge(node3,node8, 1);
      graph.addEdge(node3,node0,9);
      graph.addEdge(node3,node2,5);
      graph.addEdge(node1,node5, 2);
      graph.addEdge(node1,node8, 4);
      graph.addEdge(node8,node5, 7);
      graph.addEdge(node2,node7, 7);
      graph.addEdge(node4,node0, 13);
      graph.addEdge(node5,node9, 8);
      graph.addEdge(node6,node5, 3);
      graph.addEdge(node6,node9, 4);
      graph.addEdge(node7,node0, 12);
      graph.addEdge(node9,node0, 11);

      //shortest path from this node
      Node<Integer> startNode = node3;

      //to this node
      Node<Integer> endNode = node9;

      List<Node<Integer>> thelist = finder.shortestpath(graph, startNode ,endNode);
      printNodes(thelist);
   }

   private static void printNodes(List<Node<Integer>> thelist){
      String string = "";
      for(Node<Integer> node : thelist){
         System.out.print(string);
         string = " --> ";
         node.printNode();
      }
   }
}