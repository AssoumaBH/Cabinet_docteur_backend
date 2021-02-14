package com.example.cabinet_Doctor.payload.responses;

import lombok.Data;
import lombok.NonNull;

@Data

public class MessageResponse {
    @NonNull
    private String message;

    public MessageResponse(String message) {
        this.message =message;
    }
}