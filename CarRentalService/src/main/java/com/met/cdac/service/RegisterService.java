package com.met.cdac.service;

import java.util.List;

import com.met.cdac.model.Register;


public interface RegisterService {
	
	 void saveUser(Register userDto);

	    Register findByEmail(String email);

	    List<Register> findAllUsers();
		 Register findByUserPwd(String pasword);

}
