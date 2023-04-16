package com.eceshopping.dto;

public class PurchasedItemDto {

    private Integer id;
    private ArticleDto article;
    private PurchaseDto purchase;
    private Integer quantity;

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

    /**
     * Getters and Setters
     */

    /**
     * @return Integer
     */

    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return ArticleDto
     */
    public ArticleDto getArticle() {
        return article;
    }

    /**
     * @param article
     */
    public void setArticle(ArticleDto article) {
        this.article = article;
    }

    /**
     * @return PurchaseDto
     */
    public PurchaseDto getPurchase() {
        return purchase;
    }

    /**
     * @param purchase
     */
    public void setPurchase(PurchaseDto purchase) {
        this.purchase = purchase;
    }

    /**
     * Builder
     * 
     * @param id
     * @return
     */
    public PurchasedItemDto id(Integer id) {
        setId(id);
        return this;
    }

    /**
     * Builder
     * 
     * @param article
     * @return
     */
    public PurchasedItemDto article(ArticleDto article) {
        setArticle(article);
        return this;
    }

    /**
     * Builder
     * 
     * @param purchase
     * @return
     */
    public PurchasedItemDto purchase(PurchaseDto purchase) {
        setPurchase(purchase);
        return this;
    }

    /**
     * Builder
     * 
     * @param quantity
     * @return
     */
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
