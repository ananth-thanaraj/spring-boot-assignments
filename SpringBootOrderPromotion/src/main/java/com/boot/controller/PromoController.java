package com.boot.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.data.PromoRepository;
import com.boot.model.Promotions;

@RestController
@RequestMapping("/promotions")
public class PromoController {

	@Autowired
	private PromoRepository prrepo;
	
	
	@PostMapping("/promos")
	ResponseEntity<Promotions> addPromotions(@RequestBody Promotions promo){
		return new ResponseEntity<Promotions>(prrepo.save(promo), HttpStatus.CREATED);
	}
	
	
	
	@PostMapping("/discount/{ordAmount}")
	ResponseEntity<String> getDiscountedPrice(@PathVariable("ordAmount") Long ordAmount){
				
		Long promos = prrepo.findAll()
				.stream()
				.filter(Long.valueOf(ordAmount) >= Long.valueOf(150) && Long.valueOf(ordAmount) <= Long.valueOf(200) ?
																pro ->  pro.getPromoCode().equals("B") : pro -> pro.getPromoCode().equals("A"))
				.map(Promotions::getDiscount)
				.min(Comparator.comparing(Long::valueOf)).get();
				
System.out.println(promos);
		Long discountedPrice = ordAmount - ((ordAmount*promos)/100);
		
		System.out.println(discountedPrice);
		
		return new ResponseEntity<>("The discountedPrice is - DiscountedPrice: "+ discountedPrice, HttpStatus.OK);
	}
	
}
