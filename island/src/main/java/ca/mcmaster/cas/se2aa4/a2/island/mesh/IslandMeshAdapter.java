/*
package ca.mcmaster.cas.se2aa4.a2.island.mesh;

import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;
import edge.Edges;
import graph.IGraph;
import node.Node;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IslandMeshAdapter<T> implements IGraph<T> {
    IslandMesh islandmesh;


    @Override
    public Node<T> addNode(Node<T> node) {
        return null;
    }

    @Override
    public Set<Node<T>> getNodes() {

        List<T> list = (List<T>) islandmesh.getConverted().getVertices();
        Set<Node<T>> set = new HashSet<>() ;
        for(T vertex : list){
            set.add(new Node(vertex));
        }
        return set;
    }

    @Override
    public Edges<T> EdgesOf(Node<T> node) {
        Edges<T> edges = new Edges<>();
        islandmesh.getConverted().getSegments().
        return null;
    }
}
*/
