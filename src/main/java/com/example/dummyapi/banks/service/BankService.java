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
        return List.of(webClient
                .get()
                .uri(jsonServer + "/banks")
                .retrieve()
                .bodyToMono(Bank[].class)
                .block());
    }

    public Bank getBankById(int id) {
        String url = String.format("%s/banks/%s", jsonServer, id);
        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(Bank.class)
                .block();

    }
}
