package com.boot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="promotions")
public class Promotions {

	@Id
	private String promoCode;
	private Long discount;
	//private Long discountPrice;
	
	public String getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	public Long getDiscount() {
		return discount;
	}
	public void setDiscount(Long discount) {
		this.discount = discount;
	}
	/*public Long getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(Long discountPrice) {
		this.discountPrice = discountPrice;
	}*/
	
	
	
}
