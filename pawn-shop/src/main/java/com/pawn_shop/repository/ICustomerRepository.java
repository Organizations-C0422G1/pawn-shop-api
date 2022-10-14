package com.pawn_shop.repository;

import com.pawn_shop.model.address.Address;
import com.pawn_shop.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "insert into pawn_shop.customer (`code`, `date_of_birth`, `email`, `gender`, `id_card`, `img_url`, `name`, `phone_number`, `status`,`address_id`)\n" +
            "VALUES(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10) ", nativeQuery = true)
    void createCustomer(String code, LocalDate dateOfBirth,
                        String email, Boolean gender, String idCard,
                        String imgUrl, String name, String phoneNumber, Boolean status, Address address);
}
