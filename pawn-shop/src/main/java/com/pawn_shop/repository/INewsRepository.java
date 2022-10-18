package com.pawn_shop.repository;

import com.pawn_shop.model.news.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INewsRepository extends JpaRepository<News, Long> {
}
