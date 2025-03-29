package com.example.hospitalreservation.model;

public class DeleteReservationResponse {
    private String message;

    private DeleteReservationResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static DeleteReservationResponse from(SuccessMessage message) {
        return new DeleteReservationResponse(message.getMessage());
    }
}