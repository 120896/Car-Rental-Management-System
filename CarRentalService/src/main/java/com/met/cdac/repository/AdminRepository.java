package com.met.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.met.cdac.model.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	@Query(value = "select * from admin where username = ?1", nativeQuery = true)
	 Admin findByUsername(String username);
}
