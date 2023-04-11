import graph.IGraph;
import graph.UndirectedGraph;
import node.Node;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import shortestpath.DijkstraShortestPath;
import shortestpath.ShortestPath;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Testable
public class ShortestPathTest {

    static IGraph<Integer> graph = new UndirectedGraph<>();
    static ShortestPath<Integer> finder = new DijkstraShortestPath<>();
    static Node<Integer> node0;
    static Node<Integer> node1;
    static Node<Integer> node2;
    static Node<Integer> node3;
    static Node<Integer> node4;
    static Node<Integer> node5;
    static Node<Integer> node6;
    static Node<Integer> node7;
    static Node<Integer> node8;
    static Node<Integer> node9;
    static Node<Integer> node12;


    @Test
    @BeforeAll
    public static void beforeTest() {
        //This graph is from the class example from 2C03 class I will include a PNG file
        node0 = graph.addNode(new Node<>(0));
        node1 = graph.addNode(new Node<>(1));
        node2 = graph.addNode(new Node<>(2));
        node3 = graph.addNode(new Node<>(3));
        node4 = graph.addNode(new Node<>(4));
        node5 = graph.addNode(new Node<>(5));
        node6 = graph.addNode(new Node<>(6));
        node7 = graph.addNode(new Node<>(7));
        node8 = graph.addNode(new Node<>(8));
        node9 = graph.addNode(new Node<>(9));
        node12 = graph.addNode(new Node<>(12));

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
    }


    /**
     * testing a regular path where answer is obvious
     */
    @Test
    public void testPath1() {
        List<Node<Integer>> checker= new ArrayList<>();
        checker.add(node4);
        checker.add(node0);
        checker.add(node7);
        assertEquals(finder.shortestpath(graph, node4 ,node7, false), checker);
    }

    /**
     * testing a path that is longer with less weight
     */
    @Test
    public void testPath2() {
        List<Node<Integer>> checker= new ArrayList<>();
        checker.add(node3);
        checker.add(node8);
        checker.add(node1);
        checker.add(node5);
        checker.add(node6);
        checker.add(node9);
        assertEquals(finder.shortestpath(graph, node3 ,node9, false), checker);
    }

    /**
     * testing to see if node 1 doesn't exist
     */
    @Test
    public void testPath3() {
        List<Node<Integer>> checker= new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> {
            finder.shortestpath(graph, new Node<>(71) ,node9, false);
        });
    }

    /**
     * testing to see if node 2 doesn't exist
     */
    @Test
    public void testPath4() {
        List<Node<Integer>> checker= new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> {
            finder.shortestpath(graph, node3 , new Node<>(71), false);
        });
    }

    /**
     * testing to see what happens when a path does not exist
     */
    @Test
    public void testPath5() {
        List<Node<Integer>> checker= new ArrayList<>();
        assertEquals(finder.shortestpath(graph, node3 ,node12, false), checker);
    }

}
