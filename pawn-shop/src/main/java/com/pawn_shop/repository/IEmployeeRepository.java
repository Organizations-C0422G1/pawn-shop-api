package com.pawn_shop.repository;

import com.pawn_shop.dto.IEmployeeDto;
import com.pawn_shop.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "select  e.id, e.address, `code`, e.date_of_birth as dateOfBirth, e.email, e.gender, e.img_url as imgUrl, `name`, e.phone_number as phoneNumber, e.salary, `status`, e.id_card as idCard, a.username from employee e join app_user a on e.id = a.employee_id where a.username = :user", nativeQuery = true)
    IEmployeeDto findByUser(@Param("user") String user);
}
