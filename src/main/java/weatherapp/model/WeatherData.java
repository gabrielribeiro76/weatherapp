package weatherapp.model;

import lombok.Data;

@Data
public class WeatherData {
    private String city;
    private String description;
    private double temperature;
}
