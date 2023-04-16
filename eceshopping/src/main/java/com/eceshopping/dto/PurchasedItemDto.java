package com.eceshopping.dto;

public class PurchasedItemDto {

    private Integer id;
    ArticleDto article;
    PurchaseDto purchase;
    Integer quantity;

    public PurchasedItemDto() {
        this.id = -1;
        this.article = null;
        this.purchase = null;
    }

    public PurchasedItemDto(Integer id, ArticleDto article, PurchaseDto purchase, Integer quantity) {
        this.id = id;
        this.article = article;
        this.purchase = purchase;
        this.quantity = quantity;
    }

    /**
     * @return Integer
     */
    public Integer getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public ArticleDto getArticle() {
        return article;
    }

    public void setArticle(ArticleDto article) {
        this.article = article;
    }

    public PurchaseDto getPurchase() {
        return purchase;
    }

    public void setPurchase(PurchaseDto purchase) {
        this.purchase = purchase;
    }

    public PurchasedItemDto id(Integer id) {
        setId(id);
        return this;
    }

    public PurchasedItemDto article(ArticleDto article) {
        setArticle(article);
        return this;
    }

    public PurchasedItemDto purchase(PurchaseDto purchase) {
        setPurchase(purchase);
        return this;
    }

    public PurchasedItemDto quantity(Integer quantity) {
        setQuantity(quantity);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", article='" + getArticle() + "'" +
                ", quantity='" + getQuantity() + "'" +
                "}";
    }

}
