package com.eceshopping.dto;

import java.time.LocalDate;

import com.eceshopping.models.UserModel;

public class PurchaseDto {
    private Integer id;
    private LocalDate date;
    private UserModel user;
    private Double amountPayed;

    public PurchaseDto() {
        this.id = -1;
        this.date = null;
        this.user = null;
        this.amountPayed = 0.0;
    }

    public PurchaseDto(Integer id, LocalDate date, UserModel user,Double amountPayed) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.amountPayed = amountPayed;
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
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

    public PurchaseDto user(UserModel user) {
        setUser(user);
        return this;
    }

    public PurchaseDto amountPayed(Double amountPayed) {
        setAmountPayed(amountPayed);
        return this;
    }




}
