package com.pawn_shop.repository;

import com.pawn_shop.model.finance.Finance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
public interface IFinanceRepository extends JpaRepository<Finance, Long> {

=======
import java.util.List;

@Transactional
public interface IFinanceRepository extends JpaRepository<Finance, Long> {

    @Query(value = "select * from finance;", nativeQuery = true)
    List<Finance> findAllFinance();
>>>>>>> bba05b2ddf91be359030c53a8e609456592c23a5

}
