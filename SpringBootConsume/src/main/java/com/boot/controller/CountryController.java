package com.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.boot.model.Country;
import com.fasterxml.jackson.annotation.JsonProperty;

@RestController
@RequestMapping("/rest")
public class CountryController {

	@JsonProperty
	private RestTemplate restTemplate;

	public CountryController(RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
	}

	@GetMapping("/consume")
	public Country getAllCountry() {

		String url = "http://services.groupkt.com/country/get/all";		 
		Country response = restTemplate.getForObject(url, Country.class);
		return response;		 
	}

}
