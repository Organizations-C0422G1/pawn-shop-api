package com.pawn_shop.repository;

import com.pawn_shop.model.finance.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFinanceRepository extends JpaRepository<Finance, Long> {
}
