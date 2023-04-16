package com.eceshopping.dto;

import com.eceshopping.models.ArticleModel;
import com.eceshopping.models.PurchaseModel;

public class PurchasedItemDto {

    private Integer id;
    ArticleModel article;
    PurchaseModel purchase;

    public PurchasedItemDto() {
        this.id = -1;
        this.article = null;
        this.purchase = null;
    }

    public PurchasedItemDto(Integer id, ArticleModel article, PurchaseModel purchase) {
        this.id = id;
        this.article = article;
        this.purchase = purchase;
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

    public ArticleModel getArticle() {
        return article;
    }

    public void setArticle(ArticleModel article) {
        this.article = article;
    }

    public PurchaseModel getPurchase() {
        return purchase;
    }

    public void setPurchase(PurchaseModel purchase) {
        this.purchase = purchase;
    }

    public PurchasedItemDto id(Integer id) {
        setId(id);
        return this;
    }

    public PurchasedItemDto article(ArticleModel article) {
        setArticle(article);
        return this;
    }

    public PurchasedItemDto purchase(PurchaseModel purchase) {
        setPurchase(purchase);
        return this;
    }

}
