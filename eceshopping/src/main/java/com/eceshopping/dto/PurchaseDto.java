package com.eceshopping.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDto {
    private Integer id;
    private LocalDate date;
    private UserDto user;
    private Double amountPayed;
    private List<PurchasedItemDto> purchasedItems;

    /**
     * Default Constructor of PurchaseDto
     */
    public PurchaseDto() {
        this.id = -1;
        this.date = null;
        this.user = null;
        this.amountPayed = 0.0;
        this.purchasedItems = new ArrayList<PurchasedItemDto>();
    }

    /**
     * Constructor of PurchaseDto
     * 
     * @param id
     * @param date
     * @param user
     * @param amountPayed
     */
    public PurchaseDto(Integer id, LocalDate date, UserDto user, Double amountPayed) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.amountPayed = amountPayed;
        this.purchasedItems = new ArrayList<PurchasedItemDto>();
    }

    /**
     * Add PurchasedItem to the list
     * 
     * @param purchasedItem
     */

    public void addPurchasedItem(PurchasedItemDto purchasedItem) {
        this.purchasedItems.add(purchasedItem);
    }

    /**
     * Remove PurchasedItem from the list
     * 
     * @param purchasedItem
     */

    public void removePurchasedItem(PurchasedItemDto purchasedItem) {
        this.purchasedItems.remove(purchasedItem);
    }

    /**
     * @return List<PurchasedItemDto>
     */

    public List<PurchasedItemDto> getPurchasedItems() {
        return purchasedItems;
    }

    /**
     * Getter and Setter
     */

    /**
     * Getter of Id
     * 
     * @return Integer
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter of Id
     * 
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter of Date
     * 
     * @return
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Setter of Date
     * 
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Getter of User
     * 
     * @return
     */
    public UserDto getUser() {
        return user;
    }

    /**
     * Setter of User
     * 
     * @param user
     */
    public void setUser(UserDto user) {
        this.user = user;
    }

    /**
     * Getter of AmountPayed
     * 
     * @return
     */
    public Double getAmountPayed() {
        return amountPayed;
    }

    /**
     * Setter of AmountPayed
     * 
     * @param amountPayed
     */
    public void setAmountPayed(Double amountPayed2) {
        this.amountPayed = amountPayed2;
    }

    /**
     * Builder id
     * 
     * @param id
     * @return
     */
    public PurchaseDto id(Integer id) {
        setId(id);
        return this;
    }

    /**
     * Builder date
     * 
     * @param date
     * @return
     */
    public PurchaseDto date(LocalDate date) {
        setDate(date);
        return this;
    }

    /**
     * Builder user
     * 
     * @param user
     * @return
     */
    public PurchaseDto user(UserDto user) {
        setUser(user);
        return this;
    }

    /**
     * Builder amountPayed
     * 
     * @param amountPayed
     * @return
     */
    public PurchaseDto amountPayed(Double amountPayed) {
        setAmountPayed(amountPayed);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", date='" + getDate() + "'" +
                ", user='" + getUser() + "'" +
                ", amountPayed='" + getAmountPayed() + "'" +
                ", purchasedItems='" + getPurchasedItems() + "'" +
                "}";
    }

}
