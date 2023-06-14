package com.example.designtest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class University {
    @JsonProperty("web_page")
    private String webPage;

    @JsonProperty("country")
    private String country;

    @JsonProperty("name")
    private String name;
}
