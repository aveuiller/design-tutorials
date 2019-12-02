package com.test.injection.weather;

import com.test.injection.thermometer.TemperatureUnit;

public enum TemperatureStatus {
    COLD("cold"),
    MODERATE("moderate"),
    WARM("warm"),
    HOT("hot");

    private final String value;

    TemperatureStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static TemperatureStatus fromTemperature(float temperature, TemperatureUnit unit) {
        temperature = TemperatureUnit.CELSIUS.convert(temperature, unit);
        if (temperature < 10) {
            return COLD;
        } else if (temperature < 20) {
            return MODERATE;
        } else if (temperature < 35) {
            return WARM;
        } else {
            return HOT;
        }
    }
}
