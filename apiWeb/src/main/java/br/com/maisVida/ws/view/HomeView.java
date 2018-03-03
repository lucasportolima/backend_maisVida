package br.com.maisVida.ws.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeView {
	
	@RequestMapping("/home")
	public String Home() {
		return "index";
	}
}
