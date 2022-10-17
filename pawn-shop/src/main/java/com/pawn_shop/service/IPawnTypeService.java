package com.pawn_shop.service;

import com.pawn_shop.model.pawn.PawnType;

import java.util.List;

public interface IPawnTypeService {
    <T>List<T> findAllPawnType(Class<T> tClass);

    <T> List<T> findAllPawnTypeByNameAndPrice(String name, String id, String priceItem, Class<T> tClass);
}
