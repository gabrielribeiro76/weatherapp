package controller;

import junit.framework.TestCase;
import weatherapp.controller.WeatherController;
import weatherapp.model.WeatherData;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class WeatherControllerTest extends TestCase {

    public void testDisplayWeatherInfo() {
        WeatherController weatherController = new WeatherController();

        WeatherData weatherData = new WeatherData();
        weatherData.setCity("TestCity");
        weatherData.setDescription("Cloudy");
        weatherData.setTemperature(15.0);

        try {
            weatherController.displayWeatherInfo(null);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Esperado, faz nada
        }
    }

    public void testMainWithValidInput() {
        WeatherController weatherController = new WeatherController();

        // Simula uma entrada do usuário
        String input = "TestCity\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        try {
            weatherController.main(new String[0]);
        } catch (Exception e) {
            // Se ocorrer uma exceção, falha no teste
            fail("Unexpected exception: " + e.getMessage());
        }

        // Verifica se a saída no console contém a cidade
        assertEquals("City: TestCity\n", weatherController.getConsoleOutput());
    }
}
