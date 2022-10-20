package com.pawn_shop.repository;

import com.pawn_shop.model.finance.Finance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IFinanceRepository extends JpaRepository<Finance, Long> {

    @Query(value = "select * from finance;", nativeQuery = true)
    List<Finance> findAllFinance();

    @Query(value = "select sum(item_price) as total_investment from contract where status =0", nativeQuery = true)
    Double findTotalInvestment();

    @Query(value = "select sum((item_price)*interest_rate/100) as total_expected_profit from contract where status = 0", nativeQuery = true)
    Double findTotalExpectedProfit();

}
