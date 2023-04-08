package ca.mcmaster.cas.se2aa4.a2.island.settlement;

import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;

public class City implements ISettlement{
    private Vertex vertex;
    private float thickness = 12;
    public City(Vertex vertex){
        this.vertex = vertex;
    }

    @Override
    public Vertex getVertex() {
        return vertex;
    }

    @Override
    public float getThickness() {
        return this.thickness;
    }
}
