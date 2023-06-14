package com.example.designtest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserInfo {
    @JsonProperty("name") // "name" is the key in the JSON response
    private String user_name;
    private Address address;
}
