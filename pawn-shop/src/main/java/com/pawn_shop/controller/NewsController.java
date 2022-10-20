package com.pawn_shop.controller;

import com.pawn_shop.dto.NewsDto;
import com.pawn_shop.model.news.News;
import com.pawn_shop.service.INewsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/news")
public class NewsController {
    @Autowired
    private INewsService iNewsService;


    @GetMapping(value = "/list")
    public ResponseEntity<List<News>> goList() {
        List<News> newsList = this.iNewsService.findAll();
        if (newsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> createNews(@Valid @RequestBody NewsDto newsDto, BindingResult bindingResult) {
        new NewsDto().validate(newsDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> errMap = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(errMap, HttpStatus.BAD_REQUEST);
        }
        News news = new News();
        BeanUtils.copyProperties(newsDto, news);
        news.setPostingDay(LocalDate.parse(newsDto.getPostingDay()));
        this.iNewsService.saveNews(news);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
