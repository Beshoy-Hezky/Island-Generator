package ca.mcmaster.cas.se2aa4.a2.mesh.adt.polygon;

import ca.mcmaster.cas.se2aa4.a2.io.Structs;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.Util;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.properties.ColorProperty;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.properties.Properties;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.properties.Property;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.segment.Segment;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.segment.Segments;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.services.*;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Polygon implements Indexable, IProperties, Renderable, Colorable, Copier<Polygon>,
        Converter<Structs.Polygon>, Neighborable<Polygon>, Positionable<Double> {

    private Vertex centroid;
    private final Segments segments;
    private final Properties properties;
    private final Polygons neighbors;
    private boolean wasRendered = false;
    private int index;

    /**
     *
     * @param segments The segments belonging to this polygon
     * @throws IllegalArgumentException If not enough segments were given to form a polygon
     * @throws IllegalStateException If the segments do not form a polygon
     */
    public Polygon(List<? extends Segment> segments) throws IllegalArgumentException, IllegalStateException {
        this.properties = new Properties();
        this.neighbors = new Polygons();
        this.segments = new Segments();
        this.segments.addAll(segments);

        this.checkIfPolygon();

        this.calculateCentroid();
        this.index = -1;
    }

    /**
     *
     * @param polygon The {@link Structs.Polygon} to wrap
     * @param segments The {@link Segment} of this polygon
     * @param centroid The centroid {@link Vertex} of this polygon
     * @throws IllegalArgumentException If not enough segments were given to form a polygon
     * @throws IllegalStateException If the segments do not form a polygon
     */
    public Polygon(
            Structs.Polygon polygon, List<? extends Segment> segments, Vertex centroid
    ) throws IllegalArgumentException, IllegalStateException {
        this(segments);

        List<Property> properties = Util.toProperties(polygon.getPropertiesList());
        this.addAllProperties(properties);

        this.centroid = centroid;
    }

    /**
     *
     * @param polygon The {@link Structs.Polygon} to wrap into an instance
     * @param segments The segments that belong to this polygon
     * @param vertices The {@link List} of all vertices
     * @param centroid The centroid {@link Structs.Vertex} of this polygon
     * @throws IllegalArgumentException If not enough segments were given to form a polygon
     * @throws IllegalStateException If the segments do not form a polygon
     */
    public Polygon(
            Structs.Polygon polygon,
            List<? extends Structs.Segment> segments,
            List<? extends Structs.Vertex> vertices,
            Structs.Vertex centroid
    ) throws IllegalArgumentException, IllegalStateException {
        this(polygon, Util.toSegments(segments, vertices), new Vertex(centroid));
        this.centroid = null;
    }

    /**
     *
     * @return All the {@link Vertex} of this polygon
     */
    public List<Vertex> getVertices() {
        return this.segments.stream().flatMap(s -> Stream.of(s.getV1(), s.getV2())).distinct()
                .collect(Collectors.toList());
    }

    /**
     *
     * @return The {@link Segments} of this polygon
     */
    public List<Segment> getSegments() {
        return new ArrayList<>(this.segments);
    }

    /**
     *
     * @return The centroid {@link Vertex} of this polygon
     */
    public Vertex getCentroid() {
        return this.centroid;
    }

    /**
     * Checks if this is a correct polygon
     * @throws IllegalArgumentException If there are not enough segments to form a polygon
     * @throws IllegalStateException If the given segments do not connect
     */
    private void checkIfPolygon() throws IllegalArgumentException, IllegalStateException {
        if(this.segments.size() < 3)
            throw new IllegalArgumentException("Need at least 3 segments to form a polygon!");
        else if(!this.segmentsConnect())
            throw new IllegalStateException("The given segments do not form a polygon!");
    }

    /**
     *
     * @return True if all the {@link Segments} connect. False otherwise.
     */
    private boolean segmentsConnect() {
        for(int i=0; i < this.segments.size(); i++) {
            Segment segment1 = this.segments.get(i);
            Segment segment2 = this.segments.get((i+1) % this.segments.size());

            if(!segment1.shareVertex(segment2)) { // Second vertex of first segment and first of second segment dont match?
                return false;
            }
        }

        return true;
    }

    /**
     * Calculates the centroid vertex of this polygon
     */
    public void calculateCentroid() {
        List<Vertex> vertices = this.getVertices();

        // Find (x, y) coordinates of the centroid
        double x = vertices.stream().mapToDouble(Vertex::getX).average().getAsDouble();
        double y = vertices.stream().mapToDouble(Vertex::getY).average().getAsDouble();

        this.centroid = new Vertex(x, y);
        this.centroid.setAsCentroid(true);
        this.centroid.setColor(Color.RED);
        this.centroid.setThickness(4);
    }

    @Override
    public void setColor(Color color) {
        this.addProperty(new ColorProperty(color));
    }

    @Override
    public Color getColor() {
        return Util.extractColor(this);
    }

    @Override
    public Structs.Polygon getConverted() {
        List<Integer> segmentIdx = this.segments.stream().map(Segment::getIndex).toList();
        List<Integer> neighborIdx = this.neighbors.stream().map(Polygon::getIndex).toList();
        return Structs.Polygon.newBuilder().addAllSegmentIdxs(segmentIdx).setCentroidIdx(this.centroid.getIndex())
                .addAllProperties(this.properties.getConverted()).addAllNeighborIdxs(neighborIdx).build();
    }

    @Override
    public void addProperty(Property property) {
        this.properties.add(property);
    }

    @Override
    public void addAllProperties(Iterable<? extends Property> properties) {
        properties.forEach(this::addProperty);
    }

    @Override
    public Property getProperty(String key) {
        Optional<Property> property = this.properties.stream().filter(p -> p.getKey().equals(key)).findFirst();
        return property.orElse(null);
    }

    @Override
    public List<Property> getProperties() {
        return new ArrayList<>(this.properties);
    }

    @Override
    public void setIndex(int index) {
        if(this.index == -1 && index >= 0)
            this.index = index;
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public void draw(Graphics2D canvas) {
        if(!this.wasRendered) {
            Path2D area = new Path2D.Double();

            // Get first two segments
            Segment s1 = this.segments.get(0);
            Segment s2 = this.segments.get(1);

            // Get shared vertex between two segments
            Vertex v = s1.getSharedVertex(s2);

            // Start at the vertex that is not shared by both
            Vertex initialVertex;
            if(s1.getV1().equals(v))
                initialVertex = s1.getV2();
            else
                initialVertex = s1.getV1();

            area.moveTo(initialVertex.getX(), initialVertex.getY());

            // Keep track of the position of the last loop
            AtomicReference<Point2D> lastPos = new AtomicReference<>(area.getCurrentPoint());

            this.segments.forEach(s -> {
                // Get vertices
                Vertex v1 = s.getV1();
                Vertex v2 = s.getV2();

                if (lastPos.get().getX() != v1.getX() || lastPos.get().getY() != v1.getY()) // Not the same position as the last loop?
                    area.lineTo(s.getV1().getX(), s.getV1().getY());

                if (lastPos.get().getX() != v2.getX() || lastPos.get().getY() != v2.getY()) // Not the same position as the last loop?
                    area.lineTo(s.getV2().getX(), s.getV2().getY());

                // Update last point
                lastPos.set(area.getCurrentPoint());
            });
            area.closePath();

            // Draw area
            canvas.setColor(this.getColor());
            canvas.draw(area);
            canvas.fill(area);

            this.wasRendered = true;
        }
    }

    @Override
    public List<Polygon> getNeighbors() {
        return new ArrayList<>(this.neighbors);
    }

    @Override
    public void addNeighbor(Polygon polygon) {
        if(this.isNeighbor(polygon))
            this.neighbors.add(polygon);
    }

    @Override
    public void addNeighbors(List<Polygon> polygons) {
        polygons.forEach(this::addNeighbor);
    }

    @Override
    public boolean isNeighbor(Polygon polygon) {
        // Look for common vertices
        List<Vertex> vertices = this.getVertices();
        List<Vertex> polygonVertices = polygon.getSegments().stream().flatMap(s -> Stream.of(s.getV1(), s.getV2()))
                .distinct().toList();
        vertices.retainAll(polygonVertices);

        return !this.equals(polygon) && vertices.size() != 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polygon polygon = (Polygon) o;
        return Objects.equals(centroid, polygon.centroid) && Objects.equals(segments, polygon.segments);
    }

    @Override
    public void copy(Polygon polygon) {
        this.centroid.copy(polygon.getCentroid());
        this.segments.copy(polygon.segments);
        this.properties.copy(polygon.properties);
        this.neighbors.copy(polygon.neighbors);
        this.index = polygon.getIndex();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.segments, this.index);
    }

    @Override
    public Double getX() {
        return this.centroid.getX();
    }

    @Override
    public Double getY() {
        return this.centroid.getY();
    }

    @Override
    public Double[] getPosition() {
        return new Double[]{this.getX(), this.getY()};
    }
}