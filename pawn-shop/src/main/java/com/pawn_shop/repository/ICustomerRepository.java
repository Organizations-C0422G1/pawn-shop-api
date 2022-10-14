package com.pawn_shop.repository;

import com.pawn_shop.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select  * from customer where id=:id and status_delete=0", nativeQuery = true)
   public Optional<Customer> findById(int id);
}
