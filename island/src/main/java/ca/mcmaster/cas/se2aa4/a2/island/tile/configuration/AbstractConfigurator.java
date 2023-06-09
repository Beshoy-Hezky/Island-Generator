package ca.mcmaster.cas.se2aa4.a2.island.tile.configuration;

import ca.mcmaster.cas.se2aa4.a2.island.elevation.handler.ElevationHandler;
import ca.mcmaster.cas.se2aa4.a2.island.humidity.handlers.HumidityHandler;
import ca.mcmaster.cas.se2aa4.a2.island.color.ColorGenerator;

import java.awt.*;

public class AbstractConfigurator implements Configurator {

    private final ElevationHandler elevationHandler;
    private final ColorGenerator colorGenerator;
    private final HumidityHandler humidityHandler;

    protected AbstractConfigurator(
            ColorGenerator colorGenerator,
            ElevationHandler elevationHandler,
            HumidityHandler humidityHandler
    ) {
        this.colorGenerator = colorGenerator;
        this.elevationHandler = elevationHandler;
        this.humidityHandler = humidityHandler;
    }

    @Override
    public ColorGenerator getColorGenerator() {
        return this.colorGenerator;
    }

    @Override
    public ElevationHandler getElevationHandler() {
        return this.elevationHandler;
    }

    @Override
    public HumidityHandler getHumidityHandler(){ return this.humidityHandler; }

    @Override
    public Color apply() {
        return this.colorGenerator.generateColor();
    }
}
