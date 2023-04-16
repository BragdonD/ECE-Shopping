package com.eceshopping.dto;

import java.util.ArrayList;
import java.util.List;

public class BasketDto {
    private int id;
    private UserDto user;
    private List<BasketItemDto> basketItems;
    
    public BasketDto() {
        basketItems = new ArrayList<BasketItemDto>();
    }

    public BasketDto(int id, UserDto user, List<BasketItemDto> basketItems) {
        this.id = id;
        this.user = user;
        this.basketItems = basketItems;
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

    public List<BasketItemDto> getBasketItems() {
        return this.basketItems;
    }

    public void setBasketItems(List<BasketItemDto> basketItems) {
        this.basketItems = basketItems;
    }

    public void addItem(BasketItemDto basketItem) {
        this.basketItems.add(basketItem);
    }

    public void removeItem(BasketItemDto basketItem) {
        this.basketItems.remove(basketItem);
    }

    public BasketDto id(int id) {
        setId(id);
        return this;
    }

    public BasketDto user(UserDto user) {
        setUser(user);
        return this;
    }

    public BasketDto basketItems(List<BasketItemDto> basketItems) {
        setBasketItems(basketItems);
        return this;
    }    
}
