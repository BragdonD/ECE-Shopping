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

/**
 * PurchaseModel class is used to create a purchase object that will be used to
 * store purchase information in the database.
 */
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

    /**
     * Gets the user
     * 
     * @return
     */
    public UserModel getUser() {
        return user;
    }

    /**
     * Sets the user
     * 
     * @param user
     */
    public void setUser(UserModel user) {
        this.user = user;
    }

    /**
     * Gets the amount payed
     * 
     * @return Double
     */
    public Double getAmountPayed() {
        return amountPayed;
    }

    /**
     * Sets the amount payed
     * 
     * @param double1
     */
    public void setAmountPayed(Double double1) {
        this.amountPayed = double1;
    }

    /**
     * Gets the date
     * 
     * @return LocalDate
     */
    public LocalDate getDate() {
        return date.toLocalDate();
    }

    /**
     * Sets the date
     * 
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = LocalDateTime.of(date, LocalDateTime.now().toLocalTime());
    }
}