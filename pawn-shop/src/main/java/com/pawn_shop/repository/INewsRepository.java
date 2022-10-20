package com.pawn_shop.repository;

import com.pawn_shop.dto.NewsDto;
import com.pawn_shop.model.news.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Transactional
public interface INewsRepository extends JpaRepository<News, Long> {
    @Modifying
    @Query(value = "INSERT INTO `news` (`content`, `img_url`, `posting_day`," +
            " `status`, `title`, `app_user_id`) VALUES (:content,:imgUrl, :postingDay, 0 , " +
            " :title, 1) ",nativeQuery = true)
    void saveNews(@Param("content")String content, @Param("imgUrl")String imgUrl, @Param("postingDay")LocalDate postingDay,
                  @Param("title")String title);
}
