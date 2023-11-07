package weatherapp.util;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class ApiRequestUtil {
    private static final String API_KEY = "9d0d83122b3db7ff9cfdac5de6e29b97";

    public static JsonNode fetchWeatherData(String city) {
        HttpResponse<JsonNode> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather")
                .queryString("q", city)
                .queryString("appid", API_KEY)
                .asJson();
        return response.getBody();
    }
}
