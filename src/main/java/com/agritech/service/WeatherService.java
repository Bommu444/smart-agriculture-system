package com.agritech.service;
import java.util.*; import org.springframework.stereotype.Service; import org.springframework.web.client.RestTemplate;
@Service public class WeatherService {
 public Map weather(double lat,double lon){String url="https://api.open-meteo.com/v1/forecast?latitude="+lat+"&longitude="+lon+"&current=temperature_2m,relative_humidity_2m,precipitation,wind_speed_10m&daily=precipitation_probability_max,temperature_2m_max,temperature_2m_min&timezone=auto";return new RestTemplate().getForObject(url,Map.class);}
}