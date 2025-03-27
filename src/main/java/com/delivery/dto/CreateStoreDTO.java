package com.delivery.dto;

public record CreateStoreDTO(
        String name,
        String address,

        Double latitude,

        Double longitude,

        Long shopkeeper_id
) {
}
