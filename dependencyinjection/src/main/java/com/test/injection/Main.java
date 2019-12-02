package com.test.injection;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.test.injection.weather.WeatherContract;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        Injector injector = Guice.createInjector(new WeatherModule());

        WeatherContract weather =  injector.getInstance(WeatherContract.class);
        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("The weather is %s", weather.getTemperatureStatus()));
        }
    }
}
