package com.met.cdac.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "register")
public class Register {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String username;
	

	private String email;
	 
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	@Override
	public String toString() {
		return "Register [Id=" + Id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", mblNo=" + mblNo + ", licNo=" + licNo + "]";
	}
	private String password;
	
	private String address;
	private String mblNo;
	private String licNo;


	 

	public Register(Long id, String username, String email, String password, String address, String mblNo,
			String licNo) {
		super();
		Id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
		this.mblNo = mblNo;
		this.licNo = licNo;
	}
	public Register() {
		// TODO Auto-generated constructor stub
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getMblNo() {
		return mblNo;
	}
	public void setMblNo(String mblNo) {
		this.mblNo = mblNo;
	}
	public String getLicNo() {
		return licNo;
	}
	public void setLicNo(String licNo) {
		this.licNo = licNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
