package com.pawn_shop.service.impl;

import com.pawn_shop.model.finance.Finance;
import com.pawn_shop.repository.IFinanceRepository;
import com.pawn_shop.service.IFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FinanceService implements IFinanceService {

<<<<<<< HEAD
=======
    @Autowired
    private IFinanceRepository iFinanceRepository;

    @Override
    public List<Finance> findAllFinance() {   
        return iFinanceRepository.findAllFinance();
    }

    @Override
    public Double findTotalInvestment() {
        return iFinanceRepository.findTotalInvestment();
    }

    @Override
    public Double findTotalExpectedProfit() {
        return iFinanceRepository.findTotalExpectedProfit();
    }
>>>>>>> bba05b2ddf91be359030c53a8e609456592c23a5

}
