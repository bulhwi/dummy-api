package com.example.dummyapi.reservation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reservation {
    enum ReservationType {MONTHLY, ONCE};

    @JsonProperty("id")
    private int id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("bankId")
    private int bankId;
    @JsonProperty("accountNumber")
    private String accountNumber;
    @JsonProperty("type")
    private ReservationType type;
    @JsonProperty("dateAt")
    private String dateAt;
    @JsonProperty("startAt")
    private String startAt;
    @JsonProperty("finishAt")
    private String finishAt;
    @JsonProperty("amount")
    private int amount;
    @JsonProperty("isActive")
    private Boolean isActive;
}
