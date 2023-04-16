package com.eceshopping.models;

import java.time.LocalDate;

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
        @NamedQuery(name = "PurchaseModel.findByName", query = "FROM PurchaseModel WHERE name = :name"),
})
public class PurchaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel idUser;

    @Column(name = "amountPayed")
    private Double amountPayed;

    @Column(name = "date")
    private LocalDate date;

    public PurchaseModel(int id, UserModel idUser, Double amountPayed, LocalDate date) {
        this.id = id;
        this.idUser = idUser;
        this.amountPayed = amountPayed;
        this.date = date;
    }

    public PurchaseModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserModel getIdUser() {
        return idUser;
    }

    public void setIdUser(UserModel idUser) {
        this.idUser = idUser;
    }

    public Double getAmountPayed() {
        return amountPayed;
    }

    public void setAmountPayed(Double double1) {
        this.amountPayed = double1;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override

    public String toString() {
        return "PurchaseModel [amountPayed=" + amountPayed + ", date=" + date + ", id=" + id + ", idUser=" + idUser
                + "]";
    }

}