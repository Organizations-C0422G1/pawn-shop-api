package com.pawn_shop.controller;

import com.pawn_shop.dto.projection.NewsDto;
import com.pawn_shop.model.news.News;
import com.pawn_shop.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin()
@RequestMapping("/")
public class NewsController {
    @Autowired
    private INewsService newsService;

    @GetMapping("/list-news")
    public ResponseEntity<Page<NewsDto>> getAllNews(@PageableDefault(5) Pageable pageable, @RequestParam("title") Optional<String> titleSearch,
                                                    Optional<String> firstDate,
                                                    Optional<String> lastDate) {
        String searchName = titleSearch.orElse("");
        String dateFirst = firstDate.orElse("0001-01-01");
        String dateLast = lastDate.orElse("9000-01-01");
        if(searchName.equals("")){
            searchName = "";
        }
        if(dateFirst.equals("null")){
            dateFirst = "0001-01-01";
        }
        if(dateLast.equals("null")){
            dateLast = "9000-01-01";
        }
        Page<NewsDto> newsDtos = this.newsService.findAllNews(pageable, searchName, dateFirst, dateLast);
        if (newsDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(newsDtos, HttpStatus.OK);
        }
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<News> findNewsById(@PathVariable Long id) {
        News news = newsService.getNewsById(id);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable("id") Long idDelete) {
        newsService.deleteNews(idDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
