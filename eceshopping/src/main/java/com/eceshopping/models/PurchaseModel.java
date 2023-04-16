package com.eceshopping.models;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@Table(name = "Purchases")
@NamedQueries({
        @NamedQuery(name = "PurchaseModel.findById", query = "FROM PurchaseModel WHERE id = :id"),
        @NamedQuery(name = "PurchaseModel.findAll", query = "FROM PurchaseModel"),
})
public class PurchaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @Column(name = "amountPayed")
    private Double amountPayed;

    @Column(name = "purchase_date")
    private LocalDateTime date;

    public PurchaseModel(int id, UserModel user, Double amountPayed, LocalDate date) {
        this.id = id;
        this.user = user;
        this.amountPayed = amountPayed;
        this.date = LocalDateTime.of(date, LocalDateTime.now().toLocalTime());
    }

    public PurchaseModel() {
    }

    
    /** 
     * @return int
     */
    public int getId() {
        return id;
    }

    
    /** 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
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

    public void setAmountPayed(Double double1) {
        this.amountPayed = double1;
    }

    public LocalDate getDate() {
        return date.toLocalDate();
    }

    public void setDate(LocalDate date) {
        this.date = LocalDateTime.of(date, LocalDateTime.now().toLocalTime());
    }
}