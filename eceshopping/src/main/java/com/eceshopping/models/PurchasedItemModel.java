package com.eceshopping.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 * PurchasedItemModel class is used to create a purchased item object that will
 * be used to store purchased item information in the database.
 */
@Entity
@Table(name = "Purchase_Items")
@NamedQueries({
        @NamedQuery(name = "PurchasedItemModel.findById", query = "FROM PurchasedItemModel WHERE id = :id"),
        @NamedQuery(name = "PurchasedItemModel.findAll", query = "FROM PurchasedItemModel"),
        @NamedQuery(name = "PurchasedItemModel.findAllByPurchaseId", query = "FROM PurchasedItemModel WHERE purchase = :purchase"),
})

public class PurchasedItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private PurchaseModel purchase;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ArticleModel article;

    @Column(name = "quantity")
    private int quantity;

    public PurchasedItemModel(int id, ArticleModel article, PurchaseModel purchase, int quantity) {
        this.id = id;
        this.article = article;
        this.purchase = purchase;
        this.quantity = quantity;
    }

    public PurchasedItemModel() {
    }

    /**
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * @return int
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    public PurchaseModel getPurchase() {
        return purchase;
    }

    public void setPurchase(PurchaseModel purchase) {
        this.purchase = purchase;
    }

    public ArticleModel getArticle() {
        return article;
    }

    public void setArticle(ArticleModel article) {
        this.article = article;
    }
}
