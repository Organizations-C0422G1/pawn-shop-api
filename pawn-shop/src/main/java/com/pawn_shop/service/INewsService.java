package com.pawn_shop.service;

import com.pawn_shop.dto.NewsDto;
import com.pawn_shop.model.news.News;

import java.util.List;

public interface INewsService {
    void saveNews(News news);

    List<News> findAll();
}
