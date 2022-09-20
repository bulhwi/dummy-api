package com.example.dummyapi.reservation.controller;

import com.example.dummyapi.reservation.model.Reservation;
import com.example.dummyapi.reservation.service.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags={"2. Reservation"})
@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;
    @ApiOperation(value = "예약 목록 조회")
    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getReservations() {
        List<Reservation> reservations = reservationService.getReservations();
        return ResponseEntity.ok().body(reservations);
    }

    @ApiOperation(value="예약 id 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "예약 아이디", required = true, dataTypeClass = Integer.class, paramType = "path"),
    })
    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable int id) {
        Reservation reservation = reservationService.getReservationById(id);
        return ResponseEntity.ok().body(reservation);
    }

    @ApiOperation(value = "예약 등록")
    @PostMapping("/reservation")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        Reservation addResv = reservationService.addReservation(reservation);
        return ResponseEntity.ok().body(addResv);
    }

}
