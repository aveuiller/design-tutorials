package com.test.injection.thermometer;

import java.util.concurrent.TimeUnit;

/**
 * Represents the available temperature units and a way to convert
 * between each of them.
 */
public enum TemperatureUnit {
    CELSIUS("Celsius") {
        @Override
        public float convert(float temperature, TemperatureUnit origin) {
            switch (origin) {
                case CELSIUS:
                    return temperature;
                case FAHRENHEIT:
                    return temperature * (9.0f / 5) + 32;
                default:
                    String message = String.format(
                            "Conversion from %s to %s not handled",
                            origin, CELSIUS
                    );
                    throw new RuntimeException(message);
            }
        }
    }, FAHRENHEIT("Fahrenheit") {
        @Override
        public float convert(float temperature, TemperatureUnit origin) {
            switch (origin) {
                case CELSIUS:
                    return (temperature - 32) * (5.0f / 9);
                case FAHRENHEIT:
                    return temperature;
                default:
                    String message = String.format(
                            "Conversion from %s to %s not handled",
                            origin, FAHRENHEIT
                    );
                    throw new RuntimeException(message);
            }
        }
    };

    private final String value;

    TemperatureUnit(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    /**
     * Normalize the given temperature to the given unit from the given one.
     *
     * @param temperature The Celsius temperature to normalize.
     * @param origin      The original unit of the given temperature.
     * @return The new temperature.
     */
    public abstract float convert(float temperature, TemperatureUnit origin);
}
