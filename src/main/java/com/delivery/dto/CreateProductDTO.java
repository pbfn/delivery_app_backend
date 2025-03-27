package com.delivery.dto;

public record CreateProductDTO(
        String name,
        String description,

        Double price,

        String imageUrl,

        Long store_id
) {
}
