package com.pawn_shop.service.impl;

import com.pawn_shop.repository.IPawItemRepository;
import com.pawn_shop.service.IPawItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PawItemService implements IPawItemService {
    @Autowired
    private IPawItemRepository iPawItemRepository;

    @Override
    public <T> List<T> findAllPawnItem(Class<T> tClass) {
        return iPawItemRepository.findAllPawnItem(tClass);
    }
}
