package xyz.saurjk.checkout.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.saurjk.checkout.config.Checkout;
import xyz.saurjk.checkout.config.Rules;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showHome(Model model) {
		Rules.setRules();
		model.addAttribute("rules", Rules.getRules());
		return "home";
	}
	
	@RequestMapping(value="/doorder", method=RequestMethod.POST)
	public String doCreate(Model model, @RequestParam(value = "orderItem[]") String[] orderItem){
		Checkout co = new Checkout(Rules.getRules());
		for (String item: orderItem){
			co.scan(item);
		}
		model.addAttribute("total", co.total());
		return "order";
	}
	
}
