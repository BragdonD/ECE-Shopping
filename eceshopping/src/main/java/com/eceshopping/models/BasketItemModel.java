package com.eceshopping.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Basket_Items")
public class BasketItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private BasketModel basket;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ArticleModel product;

    private Integer quantity;

    public BasketItemModel() {
    }

    public BasketItemModel(Integer id, BasketModel basket, ArticleModel product, Integer quantity) {
        this.id = id;
        this.basket = basket;
        this.product = product;
        this.quantity = quantity;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BasketModel getBasket() {
        return this.basket;
    }

    public void setBasket(BasketModel basket) {
        this.basket = basket;
    }

    public ArticleModel getProduct() {
        return this.product;
    }

    public void setProduct(ArticleModel product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BasketItemModel id(Integer id) {
        setId(id);
        return this;
    }

    public BasketItemModel basket(BasketModel basket) {
        setBasket(basket);
        return this;
    }

    public BasketItemModel product(ArticleModel product) {
        setProduct(product);
        return this;
    }

    public BasketItemModel quantity(Integer quantity) {
        setQuantity(quantity);
        return this;
    }
}
