package com.example.designtest.service;
import com.example.designtest.model.University;
import com.example.designtest.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService{
    private final RestTemplate restTemplate;

    @Autowired
    public UniversityServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public List<University> getUniversityByName(String name) {
        List<University> universities = Arrays.asList(restTemplate.getForObject(
                "http://universities.hipolabs.com/search?name=" + name,
                University[].class));
        universities.forEach(university -> System.out.println(university.toString()));
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
