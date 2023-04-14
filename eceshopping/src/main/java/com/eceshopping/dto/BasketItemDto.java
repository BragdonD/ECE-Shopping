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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BasketDto getBasket() {
        return basket;
    }

    public void setBasket(BasketDto basket) {
        this.basket = basket;
    }

    public ArticleDto getProduct() {
        return product;
    }

    public void setProduct(ArticleDto product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BasketItemDto id(int id) {
        setId(id);
        return this;
    }

    public BasketItemDto basket(BasketDto basket) {
        setBasket(basket);
        return this;
    }

    public BasketItemDto product(ArticleDto product) {
        setProduct(product);
        return this;
    }

    public BasketItemDto quantity(int quantity) {
        setQuantity(quantity);
        return this;
    }

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