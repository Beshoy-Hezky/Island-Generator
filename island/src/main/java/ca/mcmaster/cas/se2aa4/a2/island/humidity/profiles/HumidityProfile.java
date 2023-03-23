package ca.mcmaster.cas.se2aa4.a2.island.humidity.profiles;

import ca.mcmaster.cas.se2aa4.a2.island.humidity.IHumidity;

public class HumidityProfile implements IHumidity {

    private double humidity;


    @Override
    public double getHumidity() {
        return this.humidity;
    }

    @Override
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    @Override
    public void giveHumidity(IHumidity h) {
        throw new UnsupportedOperationException();
    }

}
