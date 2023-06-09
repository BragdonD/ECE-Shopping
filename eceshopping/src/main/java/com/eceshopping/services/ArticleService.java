package com.eceshopping.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eceshopping.converter.ArticleConverter;
import com.eceshopping.daos.ArticleDAO;

import com.eceshopping.dto.ArticleDto;
import com.eceshopping.models.ArticleModel;

//import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import javafx.concurrent.Task;
import javafx.scene.image.Image;

public class ArticleService {

    private ArticleDAO articleDAO;

    public ArticleService() {
        this.articleDAO = new ArticleDAO();
    }

    /**
     * @param name
     * @return ArticleDto
     * @throws EntityNotFoundException
     * @throws IOException
     */
    public ArticleDto getArticlebyname(String name) throws EntityNotFoundException, IOException {
        return ArticleConverter.convertToDto(articleDAO.getArticleByName(name));
    }

    /**
     * @param articleDto
     * @return Task<ArticleDto>
     */
    public Task<ArticleDto> saveArticleAsync(ArticleDto articleDto) {
        Task<ArticleDto> task = new Task<ArticleDto>() {
            @Override
            protected ArticleDto call() throws Exception {
                if (articleDto.getImage() == null) {
                    throw new EntityExistsException("Image is missing.");
                }

                try {
                    System.out.println(articleDto);
                    ArticleModel article = ArticleConverter.convertToModel(articleDto);
                    articleDAO.save(article);
                } catch (EntityExistsException e) {
                    System.out.println(e.getMessage());
                }

                return articleDto;
            }
        };
        return task;
    }

    /**
     * This method is used to update the name of an article.
     * 
     * @param newname
     * @param id
     * @throws EntityExistsException
     * @throws EntityNotFoundException
     */
    public void updateName(String newname, int id) throws EntityExistsException, EntityNotFoundException {
        try {
            this.articleDAO.getArticleByName(newname);
        } catch (EntityNotFoundException e) {
            if (this.articleDAO.getById(id) == null) {
                throw new EntityNotFoundException("Article does not exist.");
            }
            ArticleModel article = this.articleDAO.getById(id);
            article.setName(newname);
            this.articleDAO.update(article);
        }
    }

    /**
     * This method is used to update the price of an article.
     * 
     * @param newprice
     * @param id
     * @throws EntityExistsException
     * @throws EntityNotFoundException
     */
    public void updatePrice(double newprice, int id) throws EntityExistsException, EntityNotFoundException {
        if (this.articleDAO.getById(id) == null) {
            throw new EntityNotFoundException("Article does not exist.");
        }
        ArticleModel article = this.articleDAO.getById(id);
        article.setPrice(newprice);
        this.articleDAO.update(article);
    }

    /**
     * This method is used to update the bulkprice of an article.
     * 
     * @param newbulkprice
     * @param id
     * @throws EntityExistsException
     * @throws EntityNotFoundException
     */
    public void updateBulkprice(double newbulkprice, int id) throws EntityExistsException, EntityNotFoundException {
        if (this.articleDAO.getById(id) == null) {
            throw new EntityNotFoundException("Article does not exist.");
        }
        ArticleModel article = this.articleDAO.getById(id);
        article.setBulkprice(newbulkprice);
        this.articleDAO.update(article);
    }

    /**
     * This method is used to update the Image of an article.
     * 
     * @param image
     * @param id
     * @throws EntityExistsException
     * @throws EntityNotFoundException
     */
    public void updateImage(Image image, int id) throws EntityExistsException, EntityNotFoundException, SQLException {
        if (this.articleDAO.getById(id) == null) {
            throw new EntityNotFoundException("Article does not exist.");
        }
        ArticleModel article = this.articleDAO.getById(id);
        article.setImage(image);
        this.articleDAO.update(article);
    }

    /**
     * This method is used to update the Marque of an article.
     * 
     * @param marque
     * @param id
     * @throws EntityExistsException
     * @throws EntityNotFoundException
     */
    public void updateMarque(String marque, int id)
            throws EntityExistsException, EntityNotFoundException, SQLException {
        if (this.articleDAO.getById(id) == null) {
            throw new EntityNotFoundException("Article does not exist.");
        }
        ArticleModel article = this.articleDAO.getById(id);
        article.setMarque(marque);
        this.articleDAO.update(article);
    }

    /**
     * This method is used to update the Type of an article.
     * 
     * @param type
     * @param id
     * @throws EntityExistsException
     * @throws EntityNotFoundException
     */
    public void updateType(String type, int id) throws EntityExistsException, EntityNotFoundException, SQLException {
        if (this.articleDAO.getById(id) == null) {
            throw new EntityNotFoundException("Article does not exist.");
        }
        ArticleModel article = this.articleDAO.getById(id);
        article.setType(type);
        this.articleDAO.update(article);
    }

    /**
     * This method is used to update the Stock of an article.
     * 
     * @param stock
     * @param id
     * @throws EntityExistsException
     * @throws EntityNotFoundException
     */

    public void updateStock(Integer stock, int id) throws EntityExistsException, EntityNotFoundException, SQLException {
        this.articleDAO.getById(id);
        ArticleModel article = this.articleDAO.getById(id);
        article.setStock(stock);
        this.articleDAO.update(article);
    }

    /**
     * This method is used to update the Stock of an article.
     * 
     * @param id
     * @param stock
     * @return
     */
    public Task<Void> updateStockAsync(int id, Integer stock) {
        return new Task<Void>() {
            @Override
            public Void call() throws EntityExistsException, EntityNotFoundException, SQLException {
                if (articleDAO.getById(id) == null) {
                    throw new EntityNotFoundException("Article does not exist.");
                }
                ArticleModel article = articleDAO.getById(id);
                article.setStock(stock);
                articleDAO.update(article);
                return null;
            }
        };
    }

    /**
     * This method is used to update the Description of an article.
     * 
     * @param description
     * @param id
     * @throws EntityExistsException
     * @throws EntityNotFoundException
     */
    public void updateDescription(String description, int id)
            throws EntityExistsException, EntityNotFoundException, SQLException {
        if (this.articleDAO.getById(id) == null) {
            throw new EntityNotFoundException("Article does not exist.");
        }
        ArticleModel article = this.articleDAO.getById(id);
        article.setDescription(description);
        this.articleDAO.update(article);
    }

    /**
     * Delete an article by its name.
     * 
     * @param name
     * @throws EntityNotFoundException
     */
    public void delete(String name) throws EntityNotFoundException {
        if (this.articleDAO.getArticleByName(name) == null) {
            throw new EntityNotFoundException("User does not exist.");
        }
        ArticleModel user = this.articleDAO.getArticleByName(name);
        this.articleDAO.delete(user);
    }

    /**
     * Get all articles of the database.
     * 
     * @return
     */
    public Task<List<ArticleDto>> getAllArticles() {
        Task<List<ArticleDto>> task = new Task<List<ArticleDto>>() {
            @Override
            protected List<ArticleDto> call() throws Exception {
                List<ArticleDto> articleDtos = new ArrayList<>();
                for (ArticleModel article : articleDAO.getAll()) {
                    articleDtos.add(ArticleConverter.convertToDto(article));
                }
                return articleDtos;
            }
        };
        return task;
    }
}
