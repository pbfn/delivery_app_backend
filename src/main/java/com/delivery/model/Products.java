package com.delivery.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name = "tbProducts")
@NoArgsConstructor
@AllArgsConstructor
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String description;

    Double price;

    String imageUrl;


    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

}
