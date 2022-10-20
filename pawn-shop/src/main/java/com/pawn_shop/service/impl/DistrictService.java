package com.pawn_shop.service.impl;

import com.pawn_shop.model.address.District;
import com.pawn_shop.repository.IDistrictRepository;
import com.pawn_shop.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService implements IDistrictService {
@Autowired
private IDistrictRepository iDistrictRepository;
    @Override
    public List<District> findAll(Long city) {
        return  iDistrictRepository.findAll(city);
    }
}
