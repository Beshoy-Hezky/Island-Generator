package ca.mcmaster.cas.se2aa4.a2.island.generator.generators;

import ca.mcmaster.cas.se2aa4.a2.island.geography.Land;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.City;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.ISettlement;

import ca.mcmaster.cas.se2aa4.a2.island.tile.Tile;
import ca.mcmaster.cas.se2aa4.a2.island.tile.type.TileType;

import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


public class SettlementGenerator {

    private List<ISettlement> Settlementlist = new ArrayList<>();
    private Set<Vertex> landvertices = new HashSet<>();

    public void generateSettlement(Land land, int cities) {
        List<Tile> tiles = land.getTiles().stream().filter(tile -> tile.getType() != TileType.OCEAN && tile.getType() != TileType.LAND_WATER).toList();
        for (Tile tile : tiles) {
            for (Vertex vertex : tile.getPolygon().getVertices()) {
                landvertices.add(vertex);
            }
        }

        addCities(cities);


        generate();
    }


    private void generate() {
        for (ISettlement obj : Settlementlist) {
            Vertex vertex = obj.getVertex();
            vertex.setThickness(obj.getThickness());
            vertex.setColor(new Color(255, 0, 0));
        }
    }

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

