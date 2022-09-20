package com.example.dummyapi.banks.service;

import com.example.dummyapi.banks.model.Bank;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {
    private final WebClient webClient;

    private final ObjectMapper objectMapper;

    @Value("${json-server}")
    private String jsonServer;

    public List<Bank> getBanks() {
        try {
            String response = webClient
                    .get()
                    .uri(jsonServer + "/banks")
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            return List.of(objectMapper.readValue(response, Bank[].class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
