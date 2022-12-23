package com.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select avg(e.spent) from customer e where e.gender =:gender", nativeQuery = true)
    Double Avg(@Param("gender") String gender);
}
