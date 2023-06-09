package ca.mcmaster.cas.se2aa4.a2.island.geography;

import ca.mcmaster.cas.se2aa4.a2.island.humidity.IHumidity;
import ca.mcmaster.cas.se2aa4.a2.island.humidity.profiles.HumidityProfile;
import ca.mcmaster.cas.se2aa4.a2.island.tile.Tile;
import ca.mcmaster.cas.se2aa4.a2.island.tile.type.TileGroup;
import ca.mcmaster.cas.se2aa4.a2.island.tile.type.TileType;

import java.util.List;

public class Lake extends TiledGeography implements IHumidity {

    private final HumidityProfile humidityProfile;

    public Lake(Tile start) {
        super(TileType.LAND_WATER);
        super.addTile(start);
        this.humidityProfile = new HumidityProfile();
        this.humidityProfile.setHumidity(500f);
    }

    @Override
    public List<Tile> getNeighbors() {
        return super.tiles.stream()
                .flatMap(t -> t.getNeighbors().stream())
                .filter(t -> t.getType().getGroup() == TileGroup.LAND)
                .toList();
    }

    @Override
    public float getHumidity() {
        return this.humidityProfile.getHumidity();
    }

    @Override
    public void setHumidity(float humidity) {
        this.tiles.forEach(t -> t.setHumidity(humidity));
    }

    @Override
    public void giveHumidity(IHumidity humidity) {
        float oldHumidity = humidity.getHumidity();
        float lakeHumidity = this.getHumidity();
        humidity.setHumidity(oldHumidity+lakeHumidity);
    }
}
