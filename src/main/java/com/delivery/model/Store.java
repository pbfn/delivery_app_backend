package com.delivery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tbStores")
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

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Products> products = new ArrayList<>();

    public Store() {
    }

    public Store(String name, String address, Double latitude, Double longitude, Users shopkeeper) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.shopkeeper = shopkeeper;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Users getShopkeeper() {
        return shopkeeper;
    }

    public List<Products> getProducts() {
        return products;
    }
}
