package com.eceshopping.dto;

public class BasketDto {
    private int id;
    private UserDto user;

    public BasketDto() {
    }

    public BasketDto(int id, UserDto user) {
        this.id = id;
        this.user = user;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDto getUser() {
        return this.user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public BasketDto id(int id) {
        setId(id);
        return this;
    }

    public BasketDto user(UserDto user) {
        setUser(user);
        return this;
    }

    @Override 
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }
}
