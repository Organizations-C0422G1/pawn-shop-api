package com.pawn_shop.repository;

import com.pawn_shop.dto.CustomerDto;
import com.pawn_shop.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(nativeQuery = true, value = "select count(customer.id) as amountContract ,\n" +
            " customer.id as id,\n" +
            " customer.`name` as `name`,\n" +
            " customer.`code` as `code`,\n" +
            " customer.date_of_birth as dateOfBirth,\n" +
            " customer.email as email,\n" +
            " customer.gender as gender,\n" +
            " customer.id_card as idCard,\n" +
            " customer.img_url as imgUrl,\n" +
            " customer.phone_number as phoneNumber,\n" +
            " customer.`status` as `status`\n" +
            " from customer join contract on customer.id = contract.customer_id \n" +
            " where customer.status = 1 and customer.`name` like ?1" +
            " group by contract.customer_id",
            countQuery = "select count(customer.id) as amountContract ,\n" +
                    " customer.id as id,\n" +
                    " customer.`name` as `name`,\n" +
                    " customer.`code` as `code`,\n" +
                    " customer.date_of_birth as dateOfBirth,\n" +
                    " customer.email as email,\n" +
                    " customer.gender as gender,\n" +
                    " customer.id_card as idCard,\n" +
                    " customer.img_url as imgUrl,\n" +
                    " customer.phone_number as phoneNumber,\n" +
                    " customer.`status` as `status`\n" +
                    " from customer join contract on customer.id = contract.customer_id \n" +
                    " where customer.status = 1 and customer.`name` like ?1" +
                    " group by contract.customer_id")
    Page<CustomerDto> findAllCustomer(String name, Pageable pageable);

    @Modifying
    @Query(value = "update customer set status= 0 where id= ?1", nativeQuery = true)
    void deleteCustomer(Integer id);


}
