package com.met.cdac.model;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking_details")
public class CarBookingInfo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String firstName;
	private String lastName;
	private String email;
	private String mblNo;
	private String fromAddress;
	private String toAddress;
	private String personCount;
	private String luggageCount;
	private String journeyDate;
	private String orderDate;
	private long days;
	private String journeyTime;
	private String feedback;
	private String carName;
	private String carType;
	//private CarType carType = CarType.ECONOMY;
	//private Long carPricePerDay;
	private String returnDate;
	
	private Long carNamePrice;
	private Long carTypePrice;
	
	private String invoiceNo;
	private BigDecimal gstTax;
	private BigDecimal carPricePerDay;
	private BigDecimal totalPrice;

	
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public BigDecimal getGstTax() {
		return gstTax;
	}
	public void setGstTax(BigDecimal gstTax) {
		this.gstTax = gstTax;
	}
	public BigDecimal getCarPricePerDay() {
		return carPricePerDay;
	}
	public void setCarPricePerDay(BigDecimal carPricePerDay) {
		this.carPricePerDay = carPricePerDay;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public long getDays() {
		return days;
	}
	public void setDays(long days) {
		this.days = days;
	}
	public Long getCarNamePrice() {
		return carNamePrice;
	}
	public void setCarNamePrice(Long carNamePrice) {
		this.carNamePrice = carNamePrice;
	}
	public Long getCarTypePrice() {
		return carTypePrice;
	}
	public void setCarTypePrice(Long carTypePrice) {
		this.carTypePrice = carTypePrice;
	}
	
	public String getCarName() {
		return carName;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	

	    
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMblNo() {
		return mblNo;
	}
	public void setMblNo(String mblNo) {
		this.mblNo = mblNo;
	}
	

	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public String getPersonCount() {
		return personCount;
	}
	public void setPersonCount(String personCount) {
		this.personCount = personCount;
	}
	public String getLuggageCount() {
		return luggageCount;
	}
	public void setLuggageCount(String luggageCount) {
		this.luggageCount = luggageCount;
	}
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	public String getJourneyTime() {
		return journeyTime;
	}
	public void setJourneyTime(String journeyTime) {
		this.journeyTime = journeyTime;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	

	public CarBookingInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
