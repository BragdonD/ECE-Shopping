package com.eceshopping.models;

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
@Table(name = "Purchase_Items")
@NamedQueries({
        @NamedQuery(name = "PurchasedItemModel.findById", query = "FROM PurchasedItemModel WHERE id = :id"),
        @NamedQuery(name = "PurchasedItemModel.findAll", query = "FROM PurchasedItemModel"),
        @NamedQuery(name = "PurchasedItemModel.findByName", query = "FROM PurchasedItemModel WHERE name = :name"),
})

public class PurchasedItemModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private PurchaseModel idPurchase;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ArticleModel idArticle;
   
    

    public PurchasedItemModel(int id, ArticleModel idArticle, PurchaseModel idPurchase) {
        this.id = id;
        this.idArticle = idArticle;
        this.idPurchase = idPurchase;
    }

    public PurchasedItemModel() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PurchaseModel getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(PurchaseModel idPurchase) {
        this.idPurchase = idPurchase;
    }

    public ArticleModel getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(ArticleModel idArticle) {
        this.idArticle = idArticle;
    }

    @Override
    public String toString() {
        return "ArticleModel [id=" + id + ", idArticle=" + idArticle + ", idPurchase=" + idPurchase + "]";
    }
}
