package com.pawn_shop.repository;

import com.pawn_shop.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from customer where status = 1", nativeQuery = true)
    public List<Customer> findAllCus();

    @Query(value = "select * from customer where id = :id", nativeQuery = true)
    public Optional<Customer> findCustomerById(@Param("id") Long id);

    @Query(value = "select * from customer where id_card = :idCard", nativeQuery = true)
    public List<Customer> findCustomerByIdCard(@Param("idCard") String idCard);

    @Query(value = "select * from customer", nativeQuery = true)
    List<Customer> findAllCustomer();
}
