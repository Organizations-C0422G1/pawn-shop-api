package com.pawn_shop.repository;

import com.pawn_shop.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
//    @Query(value = "INSERT INTO customer (`name`, phone_number, `status`, address_id) " +
//            "VALUES (:name, :phoneNumber, 1, :address);",
//            nativeQuery = true)
//    void createQuickCustomer(@Param("name") String name,
//                             @Param("phoneNumber") String phoneNumber,
//                             @Param("address") Long address);
}
