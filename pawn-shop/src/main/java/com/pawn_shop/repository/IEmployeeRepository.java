package com.pawn_shop.repository;

import com.pawn_shop.dto.projections.IEmployeeDto;
import com.pawn_shop.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "")
     Page<IEmployeeDto> getAllEmployee(Pageable pageable, String searchKeyWordCode, String searchKeyWordName);

}
