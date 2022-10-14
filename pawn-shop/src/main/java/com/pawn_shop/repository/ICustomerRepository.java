package com.pawn_shop.repository;

import com.pawn_shop.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(nativeQuery = true, value = "select * from customer where status = 1 and name like ?1",
            countQuery = "select * from customer where status = 1 and name like ?1")
    Page<Customer> findAllCustomer(String name, Pageable pageable);

    @Modifying
    @Query(value = "update customer set status= 0 where id= ?1", nativeQuery = true)
    void deleteCustomer(Integer id);
}
