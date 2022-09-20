package com.example.dummyapi.reservation.service;

import com.example.dummyapi.reservation.model.Reservation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final WebClient webClient;

    private final ObjectMapper objectMapper;

    @Value("${json-server}")
    private String jsonServer;

    public List<Reservation> getReservations() {
        String response = webClient
                .get()
                .uri(jsonServer + "/reservations")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        try {
            return List.of(objectMapper.readValue(response, Reservation[].class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
