package com.eceshopping.dto;

import javafx.scene.image.Image;

public class ArticleDto {
    private Integer id;
    private String name;
    private Double price;
    private Double bulkprice;
    private Image image;
    private String type;
    private String marque;
    private String description;
    private Integer stock;

    /**
     * Default constructor for the ArticleDto class. This constructor is used to
     * create
     */
    public ArticleDto() {
        this.id = -1;
        this.name = "";
        this.price = 0.0;
        this.bulkprice = 0.0;
        this.marque = "";
        this.type = "";
        this.description = "";
        this.stock = 0;
        image = null;
    }

    /**
     * Overloaded constructor for the ArticleDto class. This constructor is used to
     * 
     * @param id        The id of the article
     * @param name      The name of the article
     * @param price     The price of the article
     * @param bulkprice The bulkprice of the article
     * @param image     The image of the article
     */
    public ArticleDto(Integer id, String name, Double price, Double bulkprice, Image image, String type,
            Integer stock, String marque, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.bulkprice = bulkprice;
        this.image = image;
        this.type = type;
        this.marque = marque;
        this.description = description;
        this.stock = stock;
    }

    /**
     * Gets the id of the article.
     * 
     * @return The id of the article
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id of the article.
     * 
     * @param id The id of the article
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the name of the article.
     * 
     * @return The name of the article
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the article.
     * 
     * @param name The name of the article
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the article.
     * 
     * @return The price of the article
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the price of the article.
     * 
     * @param d The price of the article
     */
    public void setPrice(double d) {
        this.price = d;
    }

    /**
     * Gets the bulkprice of the article.
     * 
     * @return The bulkprice of the article
     */
    public Double getBulkprice() {
        return bulkprice;
    }

    /**
     * Sets the bulkprice of the article.
     * 
     * @param bulkprice The bulkprice of the article
     */
    public void setBulkprice(double bulk) {
        this.bulkprice = bulk;
    }

    /**
     * Gets the type of the article.
     * 
     * @return The type of the article
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the article.
     * 
     * @param type The type of the article
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the marque of the article.
     * 
     * @return The marque of the article
     */
    public String getMarque() {
        return marque;
    }

    /**
     * Sets the marque of the article.
     * 
     * @param marque The marque of the article
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * Gets the image of the article.
     * 
     * @return The image of the article
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets the image of the article.
     * 
     * @param image The image of the article
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Sets the id of the article.
     * 
     * @param name
     * @return
     */
    public ArticleDto name(String name) {
        setName(name);
        return this;
    }

    /**
     * Sets the price of the article.
     * 
     * @param price
     * @return
     */
    public ArticleDto price(Double price) {
        setPrice(price);
        return this;
    }

    /**
     * Sets the bulkprice of the article.
     * 
     * @param bulkprice
     * @return
     */
    public ArticleDto bulkprice(Double bulkprice) {
        setBulkprice(bulkprice);
        return this;
    }

    /**
     * Sets the image of the article.
     * 
     * @param image
     * @return
     */
    public ArticleDto image(Image image) {
        setImage(image);
        return this;
    }

    /**
     * Sets the type of the article.
     * 
     * @param type
     * @return
     */
    public ArticleDto type(String type) {
        setType(type);
        return this;
    }

    /**
     * Sets the marque of the article.
     * 
     * @param marque
     * @return
     */
    public ArticleDto marque(String marque) {
        setMarque(marque);
        return this;
    }

    /**
     * Sets the description of the article.
     * 
     * @param description
     * @return
     */
    public ArticleDto description(String description) {
        setDescription(description);
        return this;

    }

    public void setDescription(String description2) {
        this.description = description2;
    }

    /**
     * Gets the description of the article.
     * 
     * @return The description of the article
     */

    public String getDescription() {
        return description;

    }

    /**
     * Gets the stock of the article.
     * 
     * @return The stock of the article
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * Sets the stock of the article.
     * 
     * @param stock The stock of the article
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public ArticleDto stock(Integer stock) {
        setStock(stock);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", price='" + getPrice() + "'" +
            ", bulkprice='" + getBulkprice() + "'" +
            ", image='" + getImage() + "'" +
            ", type='" + getType() + "'" +
            ", marque='" + getMarque() + "'" +
            ", description='" + getDescription() + "'" +
            ", stock='" + getStock() + "'" +
            "}";
    }
    

}
