package com.pawn_shop.service;

import java.util.List;

public interface IPawItemService {
    <T> List<T> findAllPawnItem(Class<T> tClass);
}
