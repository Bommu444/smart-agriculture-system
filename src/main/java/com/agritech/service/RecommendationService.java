package com.agritech.service;
import org.springframework.stereotype.Service; import java.util.*;
@Service public class RecommendationService {
 // Transparent starter heuristic; replace with a validated regional ML model before production use.
 public List<String> recommend(double ph,double moisture,double n,double p,double k){List<String> r=new ArrayList<>(); if(ph<5.5)r.add("Soil is acidic: request a local soil-lab lime recommendation."); else if(ph>7.8)r.add("Soil is alkaline: check micronutrient availability with a soil test."); else r.add("Soil pH is within a commonly suitable range for many crops."); if(moisture<25)r.add("Moisture is low: inspect root-zone moisture and consider irrigation."); if(n<40)r.add("Nitrogen reading is low: verify with a calibrated test before fertilizing."); if(p<20)r.add("Phosphorus reading is low: consult crop-specific nutrient guidance."); if(k<40)r.add("Potassium reading is low: review crop potassium requirements."); return r;}
}