package com.agritech.web;
import com.agritech.service.WeatherService; import org.springframework.web.bind.annotation.*; import java.util.Map;
@RestController @RequestMapping("/weather") public class WeatherController {private final WeatherService service; public WeatherController(WeatherService s){service=s;} @GetMapping public Map weather(@RequestParam(defaultValue="17.3850") double lat,@RequestParam(defaultValue="78.4867") double lon){return service.weather(lat,lon);}}
