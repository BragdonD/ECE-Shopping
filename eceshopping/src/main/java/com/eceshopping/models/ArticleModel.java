package com.eceshopping.models;

import javafx.scene.image.Image;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
@Table(name = "Products")
@NamedQueries({
        @NamedQuery(name = "ArticleModel.findById", query = "FROM ArticleModel WHERE id = :id"),
        @NamedQuery(name = "ArticleModel.findByEmail", query = "FROM ArticleModel WHERE name = :name"),
        @NamedQuery(name = "ArticleModel.findAll", query = "FROM ArticleModel"),
})
public class ArticleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "name")
    private String type;

    @NotBlank
    @Column(name = "price")
    private double price;

    @NotBlank
    @Column(name = "bulkprice")
    private double bulkprice;

    @NotBlank
    @Column(name = "stock")
    private int stock;

    @NotBlank
    @Column(name = "image")
    private Image image;
    

    public ArticleModel() {
    }

    public ArticleModel(int id, String name, String type, double price, double bulkprice, int stock, Image image) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.bulkprice = bulkprice;
        this.stock = stock;
        this.image = image;
        
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
    public String getType() {
        return type;
    }
/**
 *  Set the description of the article
 * @param description
 */
    public void setType(String description) {
        this.type = description;
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
    
/**
 * Set the id of the category of the article
 * @param idCategory
 */
    

     public void setBulkprice(double bulkprice) {
        this.bulkprice = bulkprice;
     }

    public double getBulkprice() {
        return bulkprice;
    }
}