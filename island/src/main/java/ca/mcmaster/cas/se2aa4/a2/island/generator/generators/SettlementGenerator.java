package ca.mcmaster.cas.se2aa4.a2.island.generator.generators;
import ca.mcmaster.cas.se2aa4.a2.island.geography.Land;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.City;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.ISettlement;
import ca.mcmaster.cas.se2aa4.a2.island.tile.Tile;
import ca.mcmaster.cas.se2aa4.a2.island.tile.type.TileType;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;
import node.Node;
import java.awt.Color;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


public class SettlementGenerator {

    private List<ISettlement> Settlementlist = new ArrayList<>();
    private Set<Vertex> landvertices = new HashSet<>();

    /**
     * this function gets the vertices that are not ocean or river
     * @param land land to get the land tiles
     * @param cities number of cities
     * @return return the list of Node<Vertex> that are settlements
     */
    public List<Node<Vertex>> generateSettlement(Land land, int cities) {
        List<Tile> tiles = land.getTiles().stream().filter(tile -> tile.getType() != TileType.OCEAN && tile.getType() != TileType.LAND_WATER).toList();
        for (Tile tile : tiles) {
            for (Vertex vertex : tile.getPolygon().getVertices()) {
                landvertices.add(vertex);
            }
        }
        addCities(cities);

        return generate();
    }


    /**
     * generate the vertices to the specific color and thickness
     * @return return the list of Node<Vertex> that are settlements
     */
    private List<Node<Vertex>> generate() {
        List<Node<Vertex>> vertices_of_settlements = new ArrayList<>();
        for (ISettlement obj : Settlementlist) {
            Vertex vertex = obj.getVertex();
            vertices_of_settlements.add(new Node<>(vertex));
            vertex.setThickness(obj.getThickness());
            vertex.setColor(new Color(255, 0, 0));
        }
        return vertices_of_settlements;
    }

    /**
     * Adds cities to the list of settlements
     * @param cities the number of cities generates
     */
    public void addCities(int cities) {
        Random rand = new Random();
        int num = rand.nextInt(11) + 5;
        List<Vertex> citieslist = landvertices.stream().limit(cities).collect(Collectors.toList());
        landvertices.removeAll(citieslist);
        for (Vertex vertex : citieslist) {
            Settlementlist.add(new City(vertex, rand.nextInt(11) + 5));

        }
    }
}

