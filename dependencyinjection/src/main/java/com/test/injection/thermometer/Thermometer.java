package com.test.injection.thermometer;

import com.test.injection.WeatherModule;

import javax.inject.Inject;
import javax.inject.Named;

public class Thermometer implements ThermometerContract {
    private final TemperatureUnit unit;

    // Note how the thermometer should be injectable
    // so that Guice will be able to instantiate it.
    @Inject
    // Note that the TemperatureUnit parameter is named
    // to be able to differentiate it while injecting the value,
    // since we don't have any Interface-Implementation binding.
    public Thermometer(@Named(WeatherModule.TEMPERATURE_UNIT) TemperatureUnit unit) {
        this.unit = unit;
    }

    /**
     * Private implementation returning the actual temperature from our sensor,
     * in degrees Celsius, because that's what our sensor returns.
     *
     * @return The number of °c from the sensor.
     */
    private float fetchCelsius() {
        // I lied, there isn't any sensor, only a random temperature
        // between -20°c an 50°c
        float max = 50;
        float min = -20;
        float range = max - min;
        return (float) ((Math.random() * range) + min);
    }

    @Override
    public float getTemperature() {
        return unit.convert(fetchCelsius(), TemperatureUnit.CELSIUS);
    }

    @Override
    public TemperatureUnit getUnit() {
        return unit;
    }
}
