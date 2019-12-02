package com.test.injection.weather;

import com.test.injection.thermometer.TemperatureUnit;
import com.test.injection.thermometer.ThermometerContract;
import junit.framework.TestCase;
import org.mockito.Mock;
import org.mockito.Mockito;

public class WeatherServiceTestCase extends TestCase {

    public void testTemperatureStatus() {
        ThermometerContract thermometer = Mockito.mock(ThermometerContract.class);
        Mockito.doReturn(TemperatureUnit.CELSIUS).when(thermometer).getUnit();
        WeatherContract weather = new WeatherService(thermometer);

        Mockito.doReturn(-50f).when(thermometer).getTemperature();
        assertEquals(TemperatureStatus.COLD, weather.getTemperatureStatus());
        Mockito.doReturn(0f).when(thermometer).getTemperature();
        assertEquals(TemperatureStatus.COLD, weather.getTemperatureStatus());

        Mockito.doReturn(10f).when(thermometer).getTemperature();
        assertEquals(TemperatureStatus.MODERATE, weather.getTemperatureStatus());

        Mockito.doReturn(20f).when(thermometer).getTemperature();
        assertEquals(TemperatureStatus.WARM, weather.getTemperatureStatus());
        Mockito.doReturn(34f).when(thermometer).getTemperature();
        assertEquals(TemperatureStatus.WARM, weather.getTemperatureStatus());

        Mockito.doReturn(35f).when(thermometer).getTemperature();
        assertEquals(TemperatureStatus.HOT, weather.getTemperatureStatus());

        Mockito.doReturn(50f).when(thermometer).getTemperature();
        assertEquals(TemperatureStatus.HOT, weather.getTemperatureStatus());
    }
}
