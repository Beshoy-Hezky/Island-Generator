import graph.UndirectedGraphs;
import node.Node;
import shortestpath.DijkstraShortestPath;

public class Main {
   public static void main(String[] args) {
      UndirectedGraphs<Integer> graph = new UndirectedGraphs<>();
      DijkstraShortestPath<Integer> shortestPath = new DijkstraShortestPath<>();
      Node<Integer> node3 = new Node<>(3);
      Node<Integer> node8 = new Node<>(8);
      Node<Integer> node0 = new Node<>(0);
      Node<Integer> node2 = new Node<>(2);
      Node<Integer> node1 = new Node<>(1);
      Node<Integer> node5 = new Node<>(5);
      Node<Integer> node9 = new Node<>(9);
      Node<Integer> node4 = new Node<>(4);
      Node<Integer> node6 = new Node<>(6);
      Node<Integer> node7 = new Node<>(7);

      graph.AddNode(1);
      graph.AddNode(2);
      graph.AddNode(3);
      graph.AddNode(4);
      graph.AddNode(5);
      graph.AddNode(6);
      graph.AddNode(7);
      graph.AddNode(8);
      graph.AddNode(9);


      graph.AddEdge(node3,node8, 1);
      graph.AddEdge(node3,node0,9);
      graph.AddEdge(node3,node2,5);
      graph.AddEdge(node1,node5, 2);
      graph.AddEdge(node1,node8, 4);
      //edges.add(new DirectedEdge<>(5,1, 2));
      //edges.add(new DirectedEdge<>(5,8, 7));
      //edges.add(new DirectedEdge<>(8,1, 4));
      graph.AddEdge(node8,node5, 7);
      //edges.add(new DirectedEdge<>(8,3, 1));
      //edges.add(new DirectedEdge<>(0,9, 11));
      // edges.add(new DirectedEdge<>(0,3, 9));
      //edges.add(new DirectedEdge<>(0,7, 12));
      //edges.add(new DirectedEdge<>(0,4, 13));
      //edges.add(new DirectedEdge<>(2,3, 5));
      graph.AddEdge(node2,node7, 7);
      graph.AddEdge(node4,node0, 13);
      graph.AddEdge(node5,node9, 8);
      //edges.add(new DirectedEdge<>(5,6, 3));
      graph.AddEdge(node6,node5, 3);
      graph.AddEdge(node6,node9, 4);
      graph.AddEdge(node7,node0, 12);
      //edges.add(new DirectedEdge<>(7,2, 7));
      //edges.add(new DirectedEdge<>(9,6, 4));
      //edges.add(new DirectedEdge<>(9,5, 8));
      graph.AddEdge(node9,node0, 11);

   }
}