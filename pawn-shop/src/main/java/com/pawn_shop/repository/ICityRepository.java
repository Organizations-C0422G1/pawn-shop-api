package com.pawn_shop.repository;

import com.pawn_shop.model.address.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<City,Long> {
}
