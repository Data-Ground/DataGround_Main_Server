package com.ktds.dataground.shopping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingController {
	
 	@GetMapping("/shopping")
	public String viewShoppingMapPage() {
		return "shopping/shoppingMain";
	}
	
}