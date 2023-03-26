package com.eceshopping.factories;


import com.eceshopping.dto.ArticleDto;

public class ArticleFactory {

    public static ArticleDto createArticle(String name, Double price, Double bulkprice) {
        ArticleDto newArticle = new ArticleDto()
            .name(name)
            .price(price)
            .bulkprice(bulkprice);

        return newArticle;
    }

}
