package com.eceshopping.models;

import javafx.scene.image.Image;

public class ArticleModel {
    private int id;
    private String name;
    private String description;
    private double price;
    private double bulkprice;
    private int stock;
    private Image image;
    private int idCategory;

    public ArticleModel() {
    }

    public ArticleModel(int id, String name, String description, double price, double bulkprice, int stock, Image image, int idCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.bulkprice = bulkprice;
        this.stock = stock;
        this.image = image;
        this.idCategory = idCategory;
    }
/**
 * Get the id of the article
 * @return
 */
    public int getId() {
        return id;
    }
/**
 * Set the id of the article
 * @param id
 */
    public void setId(int id) {
        this.id = id;
    }
/**
 * Get the name of the article
 * @return
 */
    public String getName() {
        return name;
    }
/**
 * Set the name of the article
 * @param name
 */
    public void setName(String name) {
        this.name = name;
    }
/**
 * Get the description of the article
 * @return
 */
    public String getDescription() {
        return description;
    }
/**
 *  Set the description of the article
 * @param description
 */
    public void setDescription(String description) {
        this.description = description;
    }
/**
 * Get the price of the article
 * @return
 */
    public double getPrice() {
        return price;
    }
/**
 * Set the price of the article
 * @param price
 */
    public void setPrice(double price) {
        this.price = price;
    }
/**
 * Get the stock of the article
 * @return
 */
    public int getStock() {
        return stock;
    }
/**
 * Set the stock of the article
 * @param stock
 */
    public void setStock(int stock) {
        this.stock = stock;
    }
/**
 *  Get the image of the article
 * @return
 */
    public Image getImage() {
        return image;
    }
/**
 *  Set the image of the article
 * @param image
 */
    public void setImage(Image image) {
        this.image = image;
    }
/**
 * Get the id of the category of the article
 * @return
 */
    public int getIdCategory() {
        return idCategory;
    }
/**
 * Set the id of the category of the article
 * @param idCategory
 */
    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

     public void setBulkprice(double bulkprice) {
        this.bulkprice = bulkprice;
     }

    public double getBulkprice() {
        return bulkprice;
    }
}