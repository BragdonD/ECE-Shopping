package com.eceshopping.dto;

import java.util.ArrayList;
import java.util.List;

public class BasketDto {
    private int id;
    private UserDto user;
    private List<BasketItemDto> basketItems;
/**
 * Default Constructor of BasketDto
 */
    public BasketDto() {
        basketItems = new ArrayList<BasketItemDto>();
    }
/**
 * Constructor of BasketDto
 * @param id
 * @param user
 * @param basketItems
 */
    public BasketDto(int id, UserDto user, List<BasketItemDto> basketItems) {
        this.id = id;
        this.user = user;
        this.basketItems = basketItems;
    }

    /**
     * @return int
     */
    public int getId() {
        return this.id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
/**
 * Getter of User
 * @return
 */
    public UserDto getUser() {
        return this.user;
    }
/**
 * Setter of User
 * @param user
 */
    public void setUser(UserDto user) {
        this.user = user;
    }

/**
 * Getter of BasketItems
 * @return
 */
    public List<BasketItemDto> getBasketItems() {
        return this.basketItems;
    }
/**
 * Setter of BasketItems
 * @param basketItems
 */
    public void setBasketItems(List<BasketItemDto> basketItems) {
        this.basketItems = basketItems;
    }
/**
 * Add Item to Basket
 * @param basketItem
 */
    public void addItem(BasketItemDto basketItem) {
        this.basketItems.add(basketItem);
    }
/**
 * Remove Item from Basket
 * @param basketItem
 */
    public void removeItem(BasketItemDto basketItem) {
        this.basketItems.remove(basketItem);
    }
/**
 * set Id
 * @param id
 * @return
 */
    public BasketDto id(int id) {
        setId(id);
        return this;
    }
/**
 * set User
 * @param user
 * @return
 */
    public BasketDto user(UserDto user) {
        setUser(user);
        return this;
    }
/**
 * set BasketItems
 */
    public BasketDto basketItems(List<BasketItemDto> basketItems) {
        setBasketItems(basketItems);
        return this;
    }
}
