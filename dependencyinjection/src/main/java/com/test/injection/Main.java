package com.test.injection;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.test.injection.thermometer.TemperatureUnit;
import com.test.injection.thermometer.Thermometer;
import com.test.injection.thermometer.ThermometerContract;
import com.test.injection.weather.TemperatureStatus;
import com.test.injection.weather.WeatherContract;
import com.test.injection.weather.WeatherService;

public class Main {

    /**
     * Uses Guice dependency injection module to instantiate
     * a {@link WeatherContract}.
     *
     * @return A {@link WeatherContract} instance
     */
    private static WeatherContract injectedWeather() {
        // Creating the Injection module.
        // This module will hold a reference to all the bindings we configured
        // and inject the needed instances as required.
        Injector injector = Guice.createInjector(new WeatherModule());

        // We ask for the injection of WeatherContract, which will create
        // an instance of ThermometerContract with the named TemperatureUnit
        // under the hood.
        return injector.getInstance(WeatherContract.class);
    }

    /**
     * This method will do the same thing as injectedWeather
     * with a manual dependency injection.
     *
     * @return A {@link WeatherContract} instance
     */
    private static WeatherContract manualWeather() {
        TemperatureUnit celsius = TemperatureUnit.CELSIUS;
        ThermometerContract thermometer = new Thermometer(celsius);
        return new WeatherService(thermometer);
    }

    public static void main(String[] args) {
        // Both injectedWeather and manualWeather will have the same behavior.
        WeatherContract weather = injectedWeather();

        for (int i = 0; i < 10; i++) {
            TemperatureStatus status = weather.getTemperatureStatus();
            System.out.println(String.format("The weather is %s", status));
        }
    }
}
