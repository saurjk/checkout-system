package xyz.saurjk.checkout.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Checkout {

	protected Map<String, PricingRules> pricingRules;
	private int totalPrice;
	protected List<String> orderList;
	Map<String, Integer> specialPricing = new HashMap<>();

	public Checkout(Map<String, PricingRules> pricingRules) {
		this.pricingRules = pricingRules;
		this.totalPrice = 0;
		this.orderList = new ArrayList<>();
	}

	public void scan(String item) {
		boolean specialPrice = false;
		try {
			PricingRules pricingRule = pricingRules.get(item);
			if (pricingRule.getSpecialPriceNumber() > 0) {
				specialPrice = true;
			}
			orderList.add(item);
			if (specialPrice && (Collections.frequency(orderList, item) % pricingRule.getSpecialPriceNumber() == 0)) {
				totalPrice = totalPrice - ((pricingRule.getSpecialPriceNumber() - 1) * pricingRule.getUnitPrice())
						+ pricingRule.getSpecialPrice();
			} else {
				totalPrice += pricingRule.getUnitPrice();
			}
		} catch (NullPointerException npe) {
			System.out.println("NullPointerException");
		}
	}

	public int total() {
		return totalPrice;
	}

}
