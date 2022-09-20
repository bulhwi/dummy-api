package com.example.dummyapi.banks.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Bank {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
}
