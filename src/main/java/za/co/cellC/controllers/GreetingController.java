package za.co.cellC.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import za.co.cellC.model.Country;

@RestController
@RequestMapping("/cellc")
public class GreetingController {

	@PostMapping("/greeting")
	public String doStuff() {
		return "Hello how are you";
	}

	@PostMapping("/internationalgreeting")
	public List<String> salute() {
		List<String> greetings = new ArrayList<>();
		greetings.add("Good morning");
		greetings.add("Bonjour");

		return greetings;
	}
	@PostMapping("/internationalsalute/{lang}/country/{zone}")
	public String greet(@PathVariable(value = "lang") String language,
			@PathVariable(value = "zone") String country) {
		if (language.equals("english")) {
			return "Good morning in "+ country;
		} else if (language.equals("french")) {
			return "Bonjour in " + country;
		}
		return "language not supported";
	}
	@PostMapping("/internationalsalute")
	public String greet(@RequestBody Country country) {
		if (country.getZone().equals("english")) {
			return "Good morning in "+ country.getName();
		} else if (country.getZone().equals("french")) {
			return "Bonjour in " + country.getName();
		}
		return "language not supported";
	}
	
}
