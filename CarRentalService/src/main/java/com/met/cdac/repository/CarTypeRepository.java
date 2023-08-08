package com.met.cdac.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.met.cdac.model.CarType;


public interface CarTypeRepository extends  JpaRepository<CarType,Long> {
	//@Query(value = "select * from cartype where car_type = ?1", nativeQuery = true)
	//CarType findByName(String name);
	//@Query(value = "select price from cartype where car_type = ?1", nativeQuery = true)
	//String findByName(String name);
	@Query(value = "select price from cartype where car_type = ?1", nativeQuery = true)
	Long findByCarName(String name);
}


