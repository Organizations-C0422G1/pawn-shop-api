package com.pawn_shop.service.impl;

import com.pawn_shop.dto.NewsDto;
import com.pawn_shop.model.news.News;
import com.pawn_shop.repository.INewsRepository;
import com.pawn_shop.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements INewsService {
    @Autowired
    private INewsRepository iNewsRepository;

    @Override
    public void saveNews(News news) {
        this.iNewsRepository.saveNews(news.getContent(),news.getImgUrl(),news.getPostingDay(),news.getTitle());
    }

    @Override
    public List<News> findAll() {
        return this.iNewsRepository.findAll();
    }
}
