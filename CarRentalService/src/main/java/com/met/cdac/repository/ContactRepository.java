package com.met.cdac.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.met.cdac.model.ContactInfo;


@Repository
public interface ContactRepository extends  JpaRepository<ContactInfo,Long> {
    
}
