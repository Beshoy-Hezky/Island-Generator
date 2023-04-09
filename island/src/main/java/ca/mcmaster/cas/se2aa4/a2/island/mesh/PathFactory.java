package ca.mcmaster.cas.se2aa4.a2.island.mesh;


import ca.mcmaster.cas.se2aa4.a2.mesh.adt.segment.Segment;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;
import graph.IGraph;
import graph.UndirectedGraph;
import node.Node;
import shortestpath.DijkstraShortestPath;

import java.awt.*;
import java.util.List;

public class PathFactory {

    public void build(IslandMesh islandMesh, List<Node<Vertex>> settlements){
        DijkstraShortestPath<Vertex> pathway = new DijkstraShortestPath<>();
        IGraph <Vertex> graph = makeGraph(islandMesh);
        for(int i = 1; i < settlements.size(); i++){
            List<Node<Vertex>> listofvertices = pathway.shortestpath(graph, settlements.get(0), settlements.get(i));
            visualizePathFinder(islandMesh, listofvertices);
        }

    }

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

    public void visualizePathFinder(IslandMesh islandMesh,List<Node<Vertex>> thelist){
        for(int i = 0; i <= thelist.size()-2; i++){
            for(Segment segment : islandMesh.getConverted().getSegments()){
                if(segment.getV1().equals(thelist.get(i).getObj()) && segment.getV2().equals(thelist.get(i+1).getObj())
               || segment.getV2().equals(thelist.get(i).getObj()) && segment.getV1().equals(thelist.get(i+1).getObj())){
                    segment.setColor(new Color(0,0,0));
                }
            }
            /*Segment segment = new Segment(thelist.get(i).getObj(), thelist.get(i+1).getObj());
            segment.setColor(new Color(0,0,0));
            islandMesh.getConverted().addSegment(segment);*/
        }
    }






}
