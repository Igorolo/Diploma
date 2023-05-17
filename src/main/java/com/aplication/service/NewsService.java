package com.aplication.service;

import com.aplication.entity.Account;
import com.aplication.entity.News;
import com.aplication.exceptions.AccountNotFoundException;
import com.aplication.exceptions.NewsNotFoundException;
import com.aplication.repository.AccountRepository;
import com.aplication.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
public class NewsService {

    private final NewsRepository newsRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository, AccountRepository accountRepository) {
        this.newsRepository = newsRepository;
        this.accountRepository = accountRepository;
    }

    public Long save(String header, String text, Date date, Long accountId) {
        Optional<Account> accountOptional = accountRepository.findById(accountId);
        Account account = accountOptional.orElseThrow(() -> new AccountNotFoundException("Unable to find account with id " + accountId));

        News news = new News(header, text, date, account);
        News savedNews = newsRepository.save(news);
        return savedNews.getNewsId();
    }

    public News getById(Long newsId) {
        return newsRepository.findById(newsId)
                .orElseThrow(() -> new NewsNotFoundException("Unable to find news with id " + newsId));
    }

    public void deleteById(Long newsId) {
        newsRepository.deleteById(newsId);
    }
}
