package com.eceshopping.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
