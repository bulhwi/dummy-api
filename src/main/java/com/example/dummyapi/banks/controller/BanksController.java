package com.example.dummyapi.banks.controller;

import com.example.dummyapi.banks.model.Bank;
import com.example.dummyapi.banks.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BanksController {

    private final BankService bankService;

    @GetMapping("/banks")
    public ResponseEntity<List<Bank>> getBanks() {
        List<Bank> banks = bankService.getBanks();
        return ResponseEntity.ok().body(banks);
    }
}
