package com.jsp.sunbase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.sunbase.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
