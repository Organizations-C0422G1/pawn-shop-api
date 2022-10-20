package com.pawn_shop.service;

import com.pawn_shop.model.address.City;

import java.util.List;

public interface ICityService {
    City findById(Long id);
    List<City> findAll();
}