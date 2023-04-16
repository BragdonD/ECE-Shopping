package com.eceshopping.converter;

import java.io.IOException;
import java.sql.SQLException;

import com.eceshopping.dto.ArticleDto;
import com.eceshopping.models.ArticleModel;

public class ArticleConverter {

    /**
     * Converts a ArticleDto object to a ArticleModel object.
     * 
     * @param articleDto The ArticleDto object to be converted
     * @return The converted ArticleModel object
     */

    public static ArticleModel convertToModel(ArticleDto articleDto) {
        ArticleModel article = new ArticleModel();
        article.setId(articleDto.getId());
        article.setName(articleDto.getName());
        article.setPrice(articleDto.getPrice());
        article.setBulkprice(articleDto.getBulkprice());
        article.setType(articleDto.getType());
        article.setDescription(articleDto.getDescription());
        article.setStock(articleDto.getStock());
        article.setMarque(articleDto.getMarque());

        try {
            article.setImage(articleDto.getImage());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while converting image");
        }
        return article;
    }

    /**
     * Converts a ArticleModel object to a ArticleDto object.
     * 
     * @param article The ArticleModel object to be converted
     * @return The converted ArticleDto object
     * @throws IOException
     */

    public static ArticleDto convertToDto(ArticleModel article) throws IOException {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(article.getId());
        articleDto.setName(article.getName());
        articleDto.setPrice(article.getPrice());
        articleDto.setBulkprice(article.getBulkprice());
        articleDto.setType(article.getType());
        articleDto.setDescription(article.getDescription());
        articleDto.setStock(article.getStock());
        articleDto.setImage(article.getImage());
        return articleDto;
    }
}
