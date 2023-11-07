package weatherapp.service;

import kong.unirest.JsonNode;
import weatherapp.model.WeatherData;
import weatherapp.util.ApiRequestUtil;

public class WeatherService {
    public WeatherData getWeatherData(String city) {
        JsonNode response = ApiRequestUtil.fetchWeatherData(city);
        WeatherData weatherData = new WeatherData();
        weatherData.setCity(city);

        if (response != null && response.getObject().has("weather")) {
            String description = response.getObject()
                    .getJSONArray("weather")
                    .getJSONObject(0)
                    .getString("description");
            weatherData.setDescription(description);
        } else {
            weatherData.setDescription("Descrição não disponível");
        }

        if (response != null && response.getObject().has("main")) {
            if (response.getObject().getJSONObject("main").has("temp")) {
                String temperatureKelvinStr = response.getObject()
                        .getJSONObject("main")
                        .getString("temp");


                temperatureKelvinStr = temperatureKelvinStr.replace(",", ".");

                double temperatureKelvin = Double.parseDouble(temperatureKelvinStr);
                double temperatureCelsius = temperatureKelvin - 273.15;


                weatherData.setTemperature(temperatureCelsius);
            } else {
                weatherData.setTemperature(Double.NaN);
            }
        } else {
            weatherData.setTemperature(Double.NaN);
        }

        return weatherData;
    }
}







