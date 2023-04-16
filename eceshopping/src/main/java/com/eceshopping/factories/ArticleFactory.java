package com.eceshopping.factories;

import com.eceshopping.dto.ArticleDto;

import javafx.scene.image.Image;

public class ArticleFactory {

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
