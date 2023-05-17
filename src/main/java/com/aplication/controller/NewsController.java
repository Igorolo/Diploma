package com.aplication.controller;

import com.aplication.controller.dto.NewsRequestDTO;
import com.aplication.controller.dto.NewsResponseDTO;
import com.aplication.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping("/news")
    public Long createNews(@RequestBody NewsRequestDTO newsRequestDTO) {
        return newsService.save(
                newsRequestDTO.getHeader(),
                newsRequestDTO.getText(),
                newsRequestDTO.getDate(),
                newsRequestDTO.getAccountId()
        );
    }

    @GetMapping("/news/{newsId}")
    public NewsResponseDTO getById(@PathVariable Long newsId) {
        return new NewsResponseDTO(newsService.getById(newsId));
    }

    @DeleteMapping("/news/{newsId}")
    public void deleteNews(@PathVariable Long newsId) {
        newsService.deleteById(newsId);
    }
}
