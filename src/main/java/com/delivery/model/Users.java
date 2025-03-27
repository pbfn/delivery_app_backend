package com.delivery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity(name = "tbUsers")
@AllArgsConstructor
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Column(unique = true, nullable = false)
    String email;

    String password;

    String address;

    Double latitude;

    Double longitude;

    @Enumerated(EnumType.STRING)
    TypeUser type;


    @OneToMany(mappedBy = "shopkeeper", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Store> stores = new ArrayList<>();

    public Users() {
    }

    public Users(String name, String email, String password, String address, Double latitude, Double longitude, TypeUser type) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.type == TypeUser.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
        if(this.type == TypeUser.CLIENT) return List.of(new SimpleGrantedAuthority("ROLE_CLIENT"));
        if(this.type == TypeUser.SHOPKEEPER) return List.of(new SimpleGrantedAuthority("ROLE_SHOPKEEPER"));
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
