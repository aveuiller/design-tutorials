package com.test.injection.weather;

import com.test.injection.thermometer.ThermometerContract;

import javax.inject.Inject;

/**
 * A weather service that will return data from a bunch of sensors.
 * <p>
 * Okay, at the moment we only have a thermometer, but stay tuned!
 */
public class WeatherService implements WeatherContract {
    private final ThermometerContract thermometer;

    // Note how the service should be injectable
    // so that Guice will be able to instantiate it.
    @Inject
    public WeatherService(ThermometerContract thermometer) {
        this.thermometer = thermometer;
    }

    @Override
    public TemperatureStatus getTemperatureStatus() {
        return TemperatureStatus.fromTemperature(
                thermometer.getTemperature(), thermometer.getUnit()
        );
    }
}
