package com.test.injection.weather;

/**
 * Interface to compute some cool stats about the weather.
 */
public interface WeatherContract {

    /**
     * Return the current temperature from our Thermometer.
     *
     * @return The current temperature.
     */
    TemperatureStatus getTemperatureStatus();
}
