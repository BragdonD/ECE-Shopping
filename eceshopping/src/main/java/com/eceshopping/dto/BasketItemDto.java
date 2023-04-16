package com.eceshopping.dto;

public class BasketItemDto {
    private int id;
    private BasketDto basket;
    private ArticleDto product;
    private int quantity;

    public BasketItemDto() {
    }

    public BasketItemDto(int id, BasketDto basket, ArticleDto product, int quantity) {
        this.id = id;
        this.basket = basket;
        this.product = product;
        this.quantity = quantity;
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
     * Getter of Basket
     * 
     * @return
     */
    public BasketDto getBasket() {
        return basket;
    }

    /**
     * Setter of Basket
     * 
     * @param basket
     */
    public void setBasket(BasketDto basket) {
        this.basket = basket;
    }

    /**
     * Getter of Product
     * 
     * @return
     */
    public ArticleDto getProduct() {
        return product;
    }

    /**
     * Setter of Product
     * 
     * @param product
     */
    public void setProduct(ArticleDto product) {
        this.product = product;
    }

    /**
     * Getter of Quantity
     * 
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter of Quantity
     * 
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * set id
     * 
     * @param id
     * @return
     */
    public BasketItemDto id(int id) {
        setId(id);
        return this;
    }

    /**
     * set basket
     * 
     * @param basket
     * @return
     */
    public BasketItemDto basket(BasketDto basket) {
        setBasket(basket);
        return this;
    }

    /**
     * set product
     * 
     * @param product
     * @return
     */
    public BasketItemDto product(ArticleDto product) {
        setProduct(product);
        return this;
    }

    /**
     * set quantity
     * 
     * @param quantity
     * @return
     */
    public BasketItemDto quantity(int quantity) {
        setQuantity(quantity);
        return this;
    }

    /**
     * @return String
     */

    @Override
    public String toString() {
        return "BasketItemDto{" +
                "id=" + id +
                ", basket=" + basket +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}