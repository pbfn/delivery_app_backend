package com.delivery.model;

public enum TypeUser {

    ADMIN("admin"),
    CLIENT("client"),
    SHOPKEEPER("shopkeeper");
    private String type;

    TypeUser(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
