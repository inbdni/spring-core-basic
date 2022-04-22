package com.inflearn.springcorebasic.order;

public class Order {

	private Long memberId;
	private String itemName;
	private int itemPrice;
	private int discountPrice;

	public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
		this.memberId = memberId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.discountPrice = discountPrice;
	}

	public int calculatePrice() {
		return itemPrice - discountPrice;
	}

	public Long getMemberId() {
		return memberId;
	}

	public String getItemName() {
		return itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	@Override
	public String toString() {
		return String.format("Order{ memberId = %d, itemName = '%s', itemPrice = %d, discountPrice = %d }",
			memberId, itemName, itemPrice, discountPrice);
	}
}
