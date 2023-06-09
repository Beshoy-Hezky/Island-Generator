package ca.mcmaster.cas.se2aa4.a2.island;

import ca.mcmaster.cas.se2aa4.a2.island.path.Path;
import ca.mcmaster.cas.se2aa4.a2.island.tile.Tile;
import ca.mcmaster.cas.se2aa4.a2.island.tile.type.TileType;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.polygon.Polygon;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.segment.Segment;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testable
public class TileTest {
    private Polygon polygon;
    private Tile tile;

    @BeforeEach
    public void beforeTest() {
        Vertex v1 = new Vertex(0, 0);
        Vertex v2 = new Vertex(100, 0);
        Vertex v3 = new Vertex(100, 100);
        Vertex v4 = new Vertex(0, 100);

        Segment s1 = new Segment(v1, v2);
        Segment s2 = new Segment(v2, v3);
        Segment s3 = new Segment(v3, v4);
        Segment s4 = new Segment(v4, v1);

        List<Segment> polygonSegments = List.of(s1, s2, s3, s4);
        List<Path> paths = polygonSegments.stream().map(Path::new).toList();

        this.polygon = new Polygon(polygonSegments);

        this.tile = new Tile(this.polygon, paths);
    }

    @Test
    public void tilePositionTest() {
        Vertex v = new Vertex(this.tile.getX(), this.tile.getY());
        assertEquals(this.polygon.getCentroid(), v);
    }

    @Test
    public void tileTypeTest() {
        TileType type = TileType.SUBTROPICAL_DESERT;

        this.tile.setType(type);
        assertEquals(this.tile.getType(), type);
        assertEquals(this.polygon.getColor(), type.getConfigurator().getColorGenerator().generateColor());

        type = TileType.OCEAN;

        this.tile.setType(type);
        assertEquals(this.tile.getType(), type);
        assertEquals(this.polygon.getColor(), type.getConfigurator().getColorGenerator().generateColor());
    }
}