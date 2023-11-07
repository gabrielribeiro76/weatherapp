package weatherapp.controller;

import weatherapp.model.WeatherData;
import weatherapp.service.WeatherService;

import java.util.Scanner;

public class WeatherController {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da cidade: ");
        String city = scanner.nextLine();

        WeatherData weatherData = weatherService.getWeatherData(city);
        displayWeatherInfo(weatherData);
    }

    private static void displayWeatherInfo(WeatherData weatherData) {
        System.out.println("City: " + weatherData.getCity());
        System.out.println("Description: " + weatherData.getDescription());
        System.out.println("Temperature: " + weatherData.getTemperature() + "°C");
    }
}

