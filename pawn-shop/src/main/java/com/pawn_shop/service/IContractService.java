package com.pawn_shop.service;

public interface IContractService {
    void createLiquidation(Double price, String dateLiquidation, Long idContract);
    Long findContractByIdPawnItem(Long idPawnItem);
}
