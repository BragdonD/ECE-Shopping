package com.eceshopping.converter;

import com.eceshopping.dto.ArticleDto;
import com.eceshopping.models.ArticleModel;

public class ArticleConverter {
    

    /**
     * Converts a ArticleDto object to a ArticleModel object. 
     * @param articleDto The ArticleDto object to be converted 
     * @return The converted ArticleModel object
     */

    public static ArticleModel convertToModel(ArticleDto articleDto) {
        ArticleModel article = new ArticleModel();
        article.setId(articleDto.getId());
        article.setName(articleDto.getName());
        article.setPrice(articleDto.getPrice());
        article.setBulkprice(articleDto.getBulkprice());
        article.setImage(articleDto.getImage());
        return article;
    }

    /**
     * Converts a ArticleModel object to a ArticleDto object. 
     * @param article The ArticleModel object to be converted
     * @return The converted ArticleDto object
     */ 

    public static ArticleDto convertToDto(ArticleModel article) {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(article.getId());
        articleDto.setName(article.getName());
        articleDto.setPrice(article.getPrice());
        articleDto.setBulkprice(article.getBulkprice());
        articleDto.setImage(article.getImage());
        return articleDto;
    }
}
