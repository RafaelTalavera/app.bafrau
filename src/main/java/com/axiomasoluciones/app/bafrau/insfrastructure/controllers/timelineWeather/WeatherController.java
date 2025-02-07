package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.timelineWeather;


import com.axiomasoluciones.app.bafrau.insfrastructure.timelineWeatherAPI.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/api/weather")
    public String getWeather(@RequestParam String latitude,
                             @RequestParam String longitude,
                             @RequestParam String startDate,
                             @RequestParam String endDate) {
        return weatherService.getWeatherData(latitude, longitude, startDate, endDate);
    }
}