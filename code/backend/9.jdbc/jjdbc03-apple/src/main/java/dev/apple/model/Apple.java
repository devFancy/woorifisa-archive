package dev.apple.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Apple {
	private int productId; // 상품 아이디
    private String category; // 상품 종류 
    private int price; // 상품 가격
    private String color; // 상품 색상
    private LocalDate releaseDate; // 상품 출시일
    
    
	public Apple(int productId, String category, int price, String color, LocalDate releaseDate) {
		super();
		this.productId = productId;
		this.category = category;
		this.price = price;
		this.color = color;
		this.releaseDate = releaseDate;
	}
}
