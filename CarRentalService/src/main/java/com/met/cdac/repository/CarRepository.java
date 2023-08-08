package com.met.cdac.repository;
import com.met.cdac.model.Car;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarRepository extends  CrudRepository<Car,Long> {
	@Query(value = "select car_price from car where car_name = ?1", nativeQuery = true)

	Long findByCarName(String name); 
}
