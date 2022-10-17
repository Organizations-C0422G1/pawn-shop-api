package com.pawn_shop.repository;

import com.pawn_shop.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "Select count(c.id)as soluong, c.name, c.phone_number, c.status, c.date_of_birth, c.code from customer c;",nativeQuery = true)
    <T> List<T> findAllBy(Class<T> tClass);

    @Query(nativeQuery = true,value = "Select c.code, c.name, c.id_card from customer c")
    <T> List<T> findAllCustomer(Class<T> tClass);

    @Query(nativeQuery = true,value = "Select c.code, c.name, c.id_card from customer c " +
            " where c.name like %?1%")
    <T> List<T> findByNameCustomer(String name,Class<T> tClass);


}
