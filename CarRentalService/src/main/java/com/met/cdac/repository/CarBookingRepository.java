package com.met.cdac.repository;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.met.cdac.model.CarBookingInfo;

import jakarta.transaction.Transactional;


public interface CarBookingRepository extends  JpaRepository<CarBookingInfo,Long> {
	@Query(value = "select * from booking_details where invoice_no = ?1", nativeQuery = true)
	CarBookingInfo findByInvoiceRefNo(String invoiceRefNo);
	
	@Query(value = "select * from booking_details where email = ?1", nativeQuery = true)
	List<CarBookingInfo> findByEmail(String email);
	
	@Transactional
	@Modifying 
	@Query(value = "update booking_details b set b.car_name_price = ?1 , b.car_type_price=?2  , b.car_price_per_day =?3 "
			+ " ,b.order_date=?4 , b.days=?5  , b.gst_tax=?6 ,b.total_price=?7 where b.invoice_no = ?8",nativeQuery = true) 
	int updateBooking_details(Long carNamePrice, Long carTypePrice ,BigDecimal carPricePerDay ,String order_date,long days,BigDecimal gst_tax,BigDecimal total_price,String invoiceNo);

}
