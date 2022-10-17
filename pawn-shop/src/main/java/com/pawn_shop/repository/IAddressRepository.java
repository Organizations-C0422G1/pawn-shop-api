package com.pawn_shop.repository;

import com.pawn_shop.model.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface IAddressRepository extends JpaRepository<Address, Long> {
//    @Query(value = "INSERT INTO address (district_id) value (?1)", nativeQuery = true)
//    void createQuickAddress(Long district);
}
