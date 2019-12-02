package com.test.injection;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.test.injection.thermometer.TemperatureUnit;
import com.test.injection.thermometer.Thermometer;
import com.test.injection.thermometer.ThermometerContract;
import com.test.injection.weather.WeatherContract;
import com.test.injection.weather.WeatherService;

/**
 * Injection module inheriting from Guice {@link AbstractModule}.
 * This module holds all the references to configurable elements in the project
 * such as the binding between Interfaces and implementations, as well as low
 * level configuration.
 */
public class WeatherModule extends AbstractModule {
    /**
     * Keyword to ask for the {@link TemperatureUnit} binding configured in the
     * module.
     */
    public static final String TEMPERATURE_UNIT = "temp_unit";

    @Override
    protected void configure() {
        // Named input configuration bindings
        bind(TemperatureUnit.class)
                .annotatedWith(Names.named(TEMPERATURE_UNIT))
                .toInstance(TemperatureUnit.CELSIUS);

        // Interface - Implementation bindings
        bind(ThermometerContract.class).to(Thermometer.class);
        bind(WeatherContract.class).to(WeatherService.class);
    }
}
