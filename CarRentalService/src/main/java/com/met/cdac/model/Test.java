package com.met.cdac.model;

import java.math.BigDecimal;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal gst_tax=new BigDecimal(12);
		BigDecimal totalPrice= (new BigDecimal(10500));
    	System.out.println("totalPrice reg:"+totalPrice);
    	BigDecimal gstPrice=totalPrice.multiply(new BigDecimal(1.12));
    	gstPrice=gstPrice.setScale(2, BigDecimal.ROUND_UP);

    	System.out.println("gstPrice reg:"+gstPrice);

	}

}
