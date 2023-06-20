package com.example.designtest.service;
import com.example.designtest.model.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.Arrays;
import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService{
    private final RestTemplate restTemplate;

    private final JsonPlaceholderService jps;

    @Autowired
    public UniversityServiceImpl(RestTemplate restTemplate, JsonPlaceholderService jps) {
        this.restTemplate = restTemplate;
        this.jps = jps;
    }


    @Override
    public List<University> getUniversityByName(String name) {
//        List<University> universities = Arrays.asList(restTemplate.getForObject(
//                "http://universities.hipolabs.com/search?name=" + name,
//                University[].class));
//        universities.forEach(university -> System.out.println(university.toString()));


        // Spring-WebFlux
        // https://adevait.com/java/spring-boot-3-0#:~:text=the%20usage%20of-,webclient,-with%20the%20JDK's

        List<University> universities = jps.getPosts(name);

        return universities;
    }

    @Override
    public List<University> getUniversitiesByCountry(String country) {
        List<University> universities = Arrays.asList(restTemplate.getForObject(
                "http://universities.hipolabs.com/search?country=" + country,
                University[].class));
        universities.forEach(university -> System.out.println(university.toString()));
        return universities;
    }
}
