package com.example.designtest.service;

import com.example.designtest.model.University;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

// http interface in Spring 6
// https://www.baeldung.com/spring-6-http-interface

public interface JsonPlaceholderService {
    @GetExchange(url ="/search")
    List<University> getPosts(@RequestParam("name") String name);
}
