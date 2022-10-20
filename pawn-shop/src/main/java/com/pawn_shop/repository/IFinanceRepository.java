package com.pawn_shop.repository;

import com.pawn_shop.model.finance.Finance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IFinanceRepository extends JpaRepository<Finance, Long> {


}
