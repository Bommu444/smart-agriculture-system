package com.agritech.web;
import com.agritech.service.RecommendationService; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/prediction") public class PredictionController {
 private final RecommendationService recommendations; public PredictionController(RecommendationService r){this.recommendations=r;}
 @GetMapping("/soil-advice") public Map<String,Object> soilAdvice(@RequestParam double ph,@RequestParam double moisture,@RequestParam double nitrogen,@RequestParam double phosphorus,@RequestParam double potassium){return Map.of("type","rule-based soil guidance","recommendations",recommendations.recommend(ph,moisture,nitrogen,phosphorus,potassium),"disclaimer","Guidance only. Confirm with a calibrated soil test and local agronomist; this is not an ML crop-yield prediction.");}
}
