package weatherapp.controller;

import org.junit.jupiter.api.Test;
import weatherapp.controller.WeatherController;
import weatherapp.model.WeatherData;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WeatherControllerTest {

    @Test
    public void testDisplayWeatherInfo() {
        WeatherController weatherController = new WeatherController();


        weatherController.displayWeatherInfo(new WeatherData());


        assertDoesNotThrow(() -> weatherController.displayWeatherInfo(new WeatherData()));
    }
}
