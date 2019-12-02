package com.test.injection.thermometer;

public interface ThermometerContract {
    /**
     * Compute the current temperature from the thermometer device.
     *
     * @return A float representing the current temperature.
     */
    float getTemperature();

    /**
     * Defines the current {@link TemperatureUnit} in which the thermometer is
     * returning data.
     *
     * @return The used {@link TemperatureUnit}.
     */
    TemperatureUnit getUnit();
}
