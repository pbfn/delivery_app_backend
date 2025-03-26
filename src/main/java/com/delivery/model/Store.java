package com.delivery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name = "tbStores")
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String address;

    Double latitude;

    Double longitude;

    @ManyToOne
    @JoinColumn(name = "shopkeeper_id", nullable = false)
    private Users shopkeeper;

}
