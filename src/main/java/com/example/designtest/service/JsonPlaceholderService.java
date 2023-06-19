package com.example.designtest.service;

import com.example.designtest.model.University;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

// http interface in Spring 6
// https://www.baeldung.com/spring-6-http-interface

public interface JsonPlaceholderService {
    @GetExchange()
    List<University> getPosts();
}
