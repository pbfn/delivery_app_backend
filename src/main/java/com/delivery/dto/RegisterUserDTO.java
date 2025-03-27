package com.delivery.dto;

import com.delivery.model.TypeUser;

public record RegisterUserDTO(
        String email,
        String password,
        String name,
        String address,

        Double latitude,

        Double longitude,
        TypeUser type
) {
}
