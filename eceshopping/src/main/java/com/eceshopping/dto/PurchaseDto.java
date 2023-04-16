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

    public PurchaseDto() {
        this.id = -1;
        this.date = null;
        this.user = null;
        this.amountPayed = 0.0;
        this.purchasedItems = new ArrayList<PurchasedItemDto>();
    }

    public PurchaseDto(Integer id, LocalDate date, UserDto user, Double amountPayed) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.amountPayed = amountPayed;
        this.purchasedItems = new ArrayList<PurchasedItemDto>();
    }

    public void addPurchasedItem(PurchasedItemDto purchasedItem) {
        this.purchasedItems.add(purchasedItem);
    }

    public void removePurchasedItem(PurchasedItemDto purchasedItem) {
        this.purchasedItems.remove(purchasedItem);
    }

    public List<PurchasedItemDto> getPurchasedItems() {
        return purchasedItems;
    }
    
    /** 
     * @return Integer
     */
    public Integer getId() {
        return id;
    }
    
    /** 
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Double getAmountPayed() {
        return amountPayed;
    }

    public void setAmountPayed(Double amountPayed2) {
        this.amountPayed = amountPayed2;
    }

    public PurchaseDto id(Integer id) {
        setId(id);
        return this;
    }

    public PurchaseDto date(LocalDate date) {
        setDate(date);
        return this;
    }

    public PurchaseDto user(UserDto user) {
        setUser(user);
        return this;
    }

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
