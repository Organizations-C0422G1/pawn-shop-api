package com.pawn_shop.repository;

import com.pawn_shop.dto.projection.IEmployeeDto;
import com.pawn_shop.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "select ee.id , ee.code ,ee.name, ee.phone_number as phoneNumber, ee.address , ee.email, ee.status " +
            "from employee as ee " +
            " where ee.status " +
            "and ee.name like concat('%' , :name , '%' ) and ee.code like concat('%' , :code , '%'  ) " +
            "order by ee.id desc ", nativeQuery = true,
            countQuery = "select ee.id , ee.code, ee.name, ee.phone_number as phoneNumber, ee.address , ee.email, ee.status " +
                    "from Employee as ee " +
                    " where ee.status = 1 " +
                    "and ee.name like concat('%' , :name , '%' ) and ee.code like concat('%' , :code , '%'  ) " +
                    "order by ee.id desc ")
    Page<IEmployeeDto> getAllEmployeeSearch(@Param("name") String searchKeyWordName, @Param("code") String searchKeyWordCode, Pageable pageable);
    
    @Transactional
    @Modifying
    @Query(value = "update employee set `status` = 0 where id = :id", nativeQuery = true)
    void deleteEmployee(@Param("id") Long id);

    @Query(value = "select * from employee where id = :id", nativeQuery = true)
    List<Employee> findByIds(Long id);
}
