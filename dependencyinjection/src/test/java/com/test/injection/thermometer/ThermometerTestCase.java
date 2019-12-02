package com.test.injection.thermometer;

import junit.framework.TestCase;
import org.junit.Assert;

public class ThermometerTestCase extends TestCase {
    public void testTemperatureLimitsAreRespected() {
        ThermometerContract thermometer = new Thermometer(TemperatureUnit.CELSIUS);

        /* Note: this test has two weak points:
        1. It relates on implementation details, i.e. the limits of
           temperatures set on our random generator, this could be enhanced by
           providing temperature limits, but that wouldn't make much sense.

        2. It is testing assertions based on probabilities, which makes it a
           potential flaky test if the specifications of the method changes.
         */
        for (int i = 0; i < 10000; i++) {
            float temperature = thermometer.getTemperature();
            Assert.assertTrue(temperature >= -20);
            Assert.assertTrue(temperature <= 50);
        }
    }
}
