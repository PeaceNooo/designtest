package com.example.designtest.controller;

import com.example.designtest.model.University;
import com.example.designtest.model.UserInfo;
import com.example.designtest.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityController {
    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping(value = "/search", params = "name")
    public List<University> getUniversityByName(@RequestParam String name) {
        return universityService.getUniversityByName(name);
    }

    @GetMapping(value = "/search", params = "country")
    public List<University> getUniversitiesByCountry(@RequestParam String country) {
        return universityService.getUniversitiesByCountry(country);
    }

}
