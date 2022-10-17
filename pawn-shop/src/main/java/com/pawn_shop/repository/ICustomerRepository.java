package com.pawn_shop.repository;

import com.pawn_shop.model.address.Address;
import com.pawn_shop.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Transactional
    @Modifying
    @Query(value = "insert into pawn_shop.customer (`date_of_birth`, `email`, `gender`, `id_card`, `img_url`, `name`, `phone_number`, `status`,`address_id`)\n" +
            "VALUES(?1,?2,?3,?4,?5,?6,?7,?8,?9) ", nativeQuery = true)
    void createCustomer( LocalDate dateOfBirth,
                        String email, Boolean gender, String idCard,
                        String imgUrl, String name, String phoneNumber, Boolean status, Address address);

    @Transactional
    @Modifying
    @Query(value = "UPDATE pawn_shop.customer\n" +
            "SET \n" +
            "`date_of_birth`= :date_of_birth,\n" +
            "`email`= :email,\n" +
            "`gender`= :gender,\n" +
            "`id_card`= :id_card,\n" +
            "`img_url`= :img_url,\n" +
            "`name`= :name,\n " +
            "`phone_number`= :phone_number,\n" +
            "`status`= :status,\n" +
            "`address_id`= :address_id\n" +
            "WHERE `id`= :id", nativeQuery = true)
    void updateCustomer(@Param("date_of_birth") LocalDate dateOfBirth, @Param("email") String email,
                        @Param("gender") Boolean gender, @Param("id_card") String idCard, @Param("img_url") String imgUrl,
                        @Param("name") String name, @Param("phone_number") String phoneNumber, @Param("status") Boolean status,
                        @Param("address_id") Long addressId, @Param("id") Long id);
}
