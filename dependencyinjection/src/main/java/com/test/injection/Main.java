package com.test.injection;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.test.injection.weather.WeatherContract;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        // Creating the Injection module.
        // This module will hold a reference to all the bindings we configured
        // and inject the needed instances as required.
        Injector injector = Guice.createInjector(new WeatherModule());

        // We ask for the injection of WeatherContract, which will create
        // an instance of ThermometerContract with the named TemperatureUnit
        // under the hood.
        WeatherContract weather = injector.getInstance(WeatherContract.class);
        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("The weather is %s", weather.getTemperatureStatus()));
        }
    }
}
