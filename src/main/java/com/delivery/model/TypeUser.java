package com.delivery.model;

import lombok.Getter;

@Getter
public enum TypeUser {

    ADMIN("admin"),
    CLIENT("client"),
    SHOPKEEPER("shopkeeper");
    private String type;

    TypeUser(String type) {
        this.type = type;
    }
}
