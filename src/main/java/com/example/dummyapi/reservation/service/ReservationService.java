package com.example.dummyapi.reservation.service;

import com.example.dummyapi.reservation.model.Reservation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final WebClient webClient;

    private final ObjectMapper objectMapper;

    @Value("${json-server}")
    private String jsonServer;

    public List<Reservation> getReservations() {
        return List.of(webClient
                .get()
                .uri(jsonServer + "/reservations")
                .retrieve()
                .bodyToMono(Reservation[].class)
                .block());
    }

    public Reservation addReservation(Reservation reservation) {
        return webClient
                .post()
                .uri(jsonServer + "/reservations")
                .bodyValue(reservation)
                .retrieve()
                .bodyToMono(Reservation.class)
                .block();

    }

    public Reservation getReservationById(int id) {
        String url = String.format("%s/reservations/%s", jsonServer, id);
        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(Reservation.class)
                .block();
    }
}
