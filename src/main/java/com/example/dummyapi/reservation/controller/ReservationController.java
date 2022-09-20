package com.example.dummyapi.reservation.controller;

import com.example.dummyapi.reservation.model.Reservation;
import com.example.dummyapi.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getReservations() {
        List<Reservation> reservations = reservationService.getReservations();
        return ResponseEntity.ok().body(reservations);
    }
}
