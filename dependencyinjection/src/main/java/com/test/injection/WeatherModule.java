package com.test.injection;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.test.injection.thermometer.TemperatureUnit;
import com.test.injection.thermometer.Thermometer;
import com.test.injection.thermometer.ThermometerContract;
import com.test.injection.weather.WeatherContract;
import com.test.injection.weather.WeatherService;

public class WeatherModule extends AbstractModule {
    public static final String TEMPERATURE_UNIT = "temp_unit";
    @Override
    protected void configure() {
        bind(TemperatureUnit.class)
                .annotatedWith(Names.named(TEMPERATURE_UNIT))
                .toInstance(TemperatureUnit.CELSIUS);
        bind(ThermometerContract.class).to(Thermometer.class);
        bind(WeatherContract.class).to(WeatherService.class);
    }
}
