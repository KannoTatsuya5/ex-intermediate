package com.example.exintermediate.form;

import org.springframework.lang.NonNull;

public class HotelFrom {
    /** 価格 */
	private String price;

	/**
	 * 価格を数値型で返します.
	 * 
	 * @return 数値に変換した価格
	 */
	public Integer getIntPrice() {
		return Integer.parseInt(this.price);
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
