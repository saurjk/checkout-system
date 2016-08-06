package xyz.saurjk.checkout.config;

import java.util.HashMap;
import java.util.Map;

public class Rules {

	static Map<String, PricingRules> rules = new HashMap<>();

	public static Map<String, PricingRules> getRules() {
		return rules;
	}
	
	public static void setRules(){
		rules.put("A", new PricingRules.MyBuilder(40).specialPrice(3, 100).build());
		rules.put("B", new PricingRules.MyBuilder(50).specialPrice(2, 80).build());
		rules.put("C", new PricingRules.MyBuilder(25).build());
		rules.put("D", new PricingRules.MyBuilder(20).build());
	}
}
