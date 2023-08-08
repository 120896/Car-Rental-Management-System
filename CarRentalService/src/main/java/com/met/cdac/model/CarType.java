package com.met.cdac.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cartype")
public class CarType {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String carType;

	 private String price;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	    public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
//    ECONOMY,
//    PREMIUM,
//    STANDARD,
//    SUV,
//    SEDAN
}
