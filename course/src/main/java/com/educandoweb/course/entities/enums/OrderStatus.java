package com.educandoweb.course.entities.enums;

public enum OrderStatus {

	WAINTING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERD(4),
	CANCELED(5);
	
	private Integer value;

	private OrderStatus(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getValue() == code ) {
				return value;
			}
		}throw new IllegalArgumentException("OrderStatus invalido ");
	}
	
	
	
}
