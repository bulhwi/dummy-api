package com.example.dummyapi.banks.controller;

import com.example.dummyapi.banks.model.Bank;
import com.example.dummyapi.banks.service.BankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(tags={"1. Bank"})
@RestController
@RequiredArgsConstructor
public class BanksController {

    private final BankService bankService;


    @ApiOperation(value = "은행 리스트 조회")
    @GetMapping("/banks")
    public ResponseEntity<List<Bank>> getBanks() {
        List<Bank> banks = bankService.getBanks();
        return ResponseEntity.ok().body(banks);
    }

    @ApiOperation(value = "은행 ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "은행 아이디", required = true, dataType = "int", paramType = "path"),
    })
    @GetMapping("/banks/{id}")
    public ResponseEntity<Bank> getBankById(@PathVariable int id) {
        Bank banks = bankService.getBankById(id);
        return ResponseEntity.ok().body(banks);
    }
}
