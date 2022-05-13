package weather.demo.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import weather.demo.client.WeatherClient;

@Service
@Slf4j
public class WeatherService {
    @Autowired
    private WeatherClient weatherClient;

    @Value("${openweathermap.api}")
    private String key;

    public String getTodayWeather(String city) throws JSONException {
        JSONObject jsonObject = new JSONObject(weatherClient.getTodayWeather(city, key, "metric"));
        log.info("Request is {}, {}", city, key);
        JSONObject result = new JSONObject();
        result.put("temp", jsonObject.getJSONObject("main").getString("temp"));
        result.put("humidity", jsonObject.getJSONObject("main").getString("humidity"));
        return result.toString();
    }
}
