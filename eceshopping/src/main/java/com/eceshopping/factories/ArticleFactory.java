package com.eceshopping.factories;

import com.eceshopping.dto.ArticleDto;

import javafx.scene.image.Image;

public class ArticleFactory {

    /**
     * Creates an article
     * @param name
     * @param price
     * @param bulkprice
     * @param stock
     * @param type
     * @param marque
     * @param image
     * @param description
     * @return ArticleDto
     */
    public static ArticleDto createArticle(String name, Double price, Double bulkprice, Integer stock, String type,
            String marque, Image image, String description) {
        ArticleDto newArticle = new ArticleDto()
                .name(name)
                .price(price)
                .bulkprice(bulkprice)
                .type(type)
                .marque(marque)
                .image(image)
                .description(description)
                .stock(stock);

        return newArticle;
    }

}
