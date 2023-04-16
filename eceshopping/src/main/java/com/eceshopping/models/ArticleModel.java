package com.eceshopping.models;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

@Entity
@Table(name = "Products")
@NamedQueries({
        @NamedQuery(name = "ArticleModel.findById", query = "FROM ArticleModel WHERE id = :id"),
        @NamedQuery(name = "ArticleModel.findByName", query = "FROM ArticleModel WHERE name = :name"),
        @NamedQuery(name = "ArticleModel.findAll", query = "FROM ArticleModel"),
})
public class ArticleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "bulk_price")
    private double bulkprice;

    @Column(name = "stock")
    private int stock;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "product_type")
    private String type;

    @Column(name = "marque")
    private String marque;

    public ArticleModel() {
    }

    public ArticleModel(int id, String name, String type, double price, double bulkprice, int stock, Image image, String description) throws SQLException {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.bulkprice = bulkprice;
        this.stock = stock;
        this.setImage(image);
        this.type = type;
    }

    /**
     * Get the id of the article
     * 
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id of the article
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }




    /**
     * Get the name of the article
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the article
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the description of the article
     * 
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the article
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the price of the article
     * 
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price of the article
     * 
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get the stock of the article
     * 
     * @return
     */
    public int getStock() {
        return stock;
    }

    /**
     * Set the stock of the article
     * 
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Get the type of the article
     * 
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Set the type of the article
     * 
     * @param string
     */
    public void setType(String string) {
        this.type = string;
    }


    /**
     * Get the image of the article
     * 
     * @return
     * @throws IOException
     */
    public Image getImage() throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(this.image));
    // do something with the image
        return SwingFXUtils.toFXImage(bufferedImage, null);
    }

    /**
     * Set the image of the article
     * 
     * @param image
     * @throws SQLException
     */
    public void setImage(Image image) throws SQLException {
        ByteArrayOutputStream oS = new ByteArrayOutputStream();
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bImage, "jpg", oS );
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing image to byte array");
        }
        this.image = oS.toByteArray();
    }

    public void setBulkprice(double bulkprice) {
        this.bulkprice = bulkprice;
    }

    public double getBulkprice() {
        return bulkprice;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public String getMarque() {
        return marque;
    }
    @Override
    public String toString() {
        return "ArticleModel [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
                + ", bulkprice=" + bulkprice + ", stock=" + stock + ", image=" + image + ", type=" + type + "]";
    }
}