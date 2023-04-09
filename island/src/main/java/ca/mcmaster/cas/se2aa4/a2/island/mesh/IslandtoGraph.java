package ca.mcmaster.cas.se2aa4.a2.island.mesh;


import ca.mcmaster.cas.se2aa4.a2.mesh.adt.segment.Segment;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;
import graph.IGraph;
import graph.UndirectedGraph;
import node.Node;

public class IslandtoGraph {



    public IGraph<Vertex> makeGraph(IslandMesh islandMesh) {
        IGraph<Vertex> graph = new UndirectedGraph<>();
        /*for (Vertex vertex : islandMesh.getConverted().getVertices()){
            graph.addNode(new Node<>(vertex));
        }*/

        for(Segment segment : islandMesh.getConverted().getSegments()){
            graph.addNode(new Node<>(segment.getV1()));
            graph.addNode(new Node<>(segment.getV2()));
            graph.addEdge(new Node<>(segment.getV1()),new Node<>(segment.getV2()), 1);
        }
        return graph;
    }


}
