package com.pawn_shop.repository;

import com.pawn_shop.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "select id, address,code, date_of_birth,email,gender,img_url,`name`,phone_number,salary,`status`,id_card \n" +
            "\tfrom employee \n" +
            "\twhere id = :id", nativeQuery = true)
    Optional<Employee> findById(@Param("id") Long id);

    @Modifying
    @Query(value = "update employee set address = :address, date_of_birth = :dateOfBirth,email = :email," +
            " gender = :gender , img_url = :imgUrl , `name` = :name, phone_number = :phoneNumber, id_card= :idCard " +
            " where id = :id", nativeQuery = true)
    void updateEmployee(@Param("address") String address, @Param("dateOfBirth") LocalDate dateOfBirth,
                @Param("email") String email, @Param("gender") Boolean gender, @Param("imgUrl") String imgUrl,
                @Param("name") String name, @Param("phoneNumber") String phoneNumber, @Param("idCard")String idCard, @Param("id") Long id);
}
