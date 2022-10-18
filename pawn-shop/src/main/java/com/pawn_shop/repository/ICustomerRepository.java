package com.pawn_shop.repository;

import com.pawn_shop.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    @Query(nativeQuery = true,value = "Select c.code, c.name, c.id_card from customer c " +
            " where c.name like %?1% and c.id_card like %?2%")
    <T> List<T> findByNameCustomer(String name,String cmnd,Class<T> tClass);


}
