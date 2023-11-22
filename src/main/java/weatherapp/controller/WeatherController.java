package weatherapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weatherapp.model.WeatherData;
import weatherapp.service.WeatherService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WeatherController {

    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);
    private static final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
    private static WeatherService weatherService = new WeatherService(); // Adicionado como um campo estático

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        logger.info("Prompting user for city name");
        System.out.print("Digite o nome da cidade: ");
        String city = scanner.nextLine();

        WeatherData weatherData = weatherService.getWeatherData(city);
        displayWeatherInfo(weatherData);
    }

    public static void displayWeatherInfo(WeatherData weatherData) {
        if (weatherData == null) {
            logger.error("Weather data is null");
            logToConsole("Weather data is null");
            return;
        }
        logger.info("Displaying weather information for city: {}", weatherData.getCity());
        logToConsole("City: " + weatherData.getCity());
        logToConsole("Description: " + weatherData.getDescription());
        logToConsole("Temperature: " + weatherData.getTemperature() + "°C");

        if (weatherData.getTemperature() < 0) {
            logger.error("Temperature is below freezing: {}°C", weatherData.getTemperature());
        } else {
            logger.info("Temperature: {}°C", weatherData.getTemperature());
        }
    }

    public static String getConsoleOutput() {
        return consoleOutput.toString();
    }

    private static void logToConsole(String message) {
        System.out.println(message);
        try {
            consoleOutput.write((message + "\n").getBytes());
        } catch (IOException e) {
            logger.error("Error writing to consoleOutput", e);
        }
    }
}
