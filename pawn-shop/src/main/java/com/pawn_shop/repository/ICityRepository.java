package com.pawn_shop.repository;

import com.pawn_shop.model.address.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICityRepository extends JpaRepository<City,Long> {
    @Query(value = "select id, `name`, prefix from pawn_shop.city ", nativeQuery = true)
    List<City> findAll();

    @Query(value = "select id, `name`, prefix from pawn_shop.city where id=?", nativeQuery = true)
    City findCityById(Long id);
}
