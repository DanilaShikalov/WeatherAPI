package weather.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "weatherDemo", url = "${openweathermap.path}")
public interface WeatherClient {
    @GetMapping
    public String getTodayWeather(@RequestParam(name = "q") String city, @RequestParam("appid") String app_id, @RequestParam String units);
}
