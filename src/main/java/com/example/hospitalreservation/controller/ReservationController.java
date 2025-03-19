package com.example.hospitalreservation.controller;

import com.example.hospitalreservation.model.Reservation;
import com.example.hospitalreservation.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public String getReservations(Model model) {
        List<Reservation> reservations = reservationService.getAllReservations();
        model.addAttribute("reservations",reservations);

        return "index.html";
    }

    @GetMapping("/reservations/new")
    public String showReservationForm() {
        return "reservation_form.html";
    }

    @PostMapping("/reservations")
    public String createReservation(@RequestParam Long doctorId, @RequestParam Long patientId) {
        reservationService.createReservation(doctorId, patientId, LocalDateTime.now());
        return "redirect:/reservations";
    }

    // TODO : 필요한 어노테이션을 작성해주세요.
    public String cancelReservation(@PathVariable Long id) {
        // TODO : 예약을 취소하는 코드를 작성해주세요.
        return "index.html";
    }
}