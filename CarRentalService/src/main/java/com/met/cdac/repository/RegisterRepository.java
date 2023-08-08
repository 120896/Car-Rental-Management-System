package com.met.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.met.cdac.model.Register;


@Repository
public interface RegisterRepository extends JpaRepository<Register, Long>{
	@Query(value = "select * from register where email = ?1", nativeQuery = true)
	 Register findByEmail(String email);
	
		


}


