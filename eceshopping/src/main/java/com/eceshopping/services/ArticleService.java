package com.eceshopping.services;
    
    
import java.io.IOException;
import java.sql.SQLException;

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

    public ArticleDto getArticlebyname(String name) throws EntityNotFoundException, IOException {
        return ArticleConverter.convertToDto(articleDAO.getArticleByName(name));
    }

    public Task<ArticleDto> saveArticleAsync(ArticleDto articleDto) {
        Task<ArticleDto> task = new Task<ArticleDto>() {
            @Override
            protected ArticleDto call() throws Exception {
                try {
                    System.out.println(articleDto);
                    articleDAO.save(ArticleConverter.convertToModel(articleDto));
                } catch (EntityExistsException e) {
                    throw e;
                }
                return articleDto;
            }
        };
        return task;
    }


    /**
     * This method is used to update the name of an article.
     * @param newname
     * @param id
     * @throws EntityExistsException
     * @throws EntityNotFoundException
     */
 public void updateName (String newname, int id) throws EntityExistsException, EntityNotFoundException {
    if (this.articleDAO.getArticleByName(newname) != null) {
        throw new EntityExistsException("Name is already in use.");
    }
    if (this.articleDAO.getById(id) == null) {
        throw new EntityNotFoundException("Article does not exist.");
    }
    ArticleModel article = this.articleDAO.getById(id);
    article.setName(newname);
    this.articleDAO.update(article);
    } 

    public void updatePrice  (double newprice, int id) throws EntityExistsException, EntityNotFoundException{
        if (this.articleDAO.getById(id) == null) {
            throw new EntityNotFoundException("Article does not exist.");
        }
        ArticleModel article = this.articleDAO.getById(id);
        article.setPrice(newprice);
        this.articleDAO.update(article);
    }

    public void updateBulkprice (double newbulkprice, int id) throws EntityExistsException, EntityNotFoundException{
        if (this.articleDAO.getById(id) == null) {
            throw new EntityNotFoundException("Article does not exist.");
        }
        ArticleModel article = this.articleDAO.getById(id);
        article.setBulkprice(newbulkprice);
        this.articleDAO.update(article);
    }
    public void updateImage(Image image, int id) throws EntityExistsException, EntityNotFoundException, SQLException{
        if (this.articleDAO.getById(id) == null) {
            throw new EntityNotFoundException("Article does not exist.");
        }
        ArticleModel article = this.articleDAO.getById(id);
        article.setImage(image);
        this.articleDAO.update(article);
    } 

    public void updateMarque(String marque, int id) throws EntityExistsException, EntityNotFoundException, SQLException{
        if (this.articleDAO.getById(id) == null) {
            throw new EntityNotFoundException("Article does not exist.");
        }
        ArticleModel article = this.articleDAO.getById(id);
        article.setMarque(marque);
        this.articleDAO.update(article);
    }

    public void updateType(String type,int id) throws EntityExistsException, EntityNotFoundException, SQLException{
        if (this.articleDAO.getById(id) == null) {
            throw new EntityNotFoundException("Article does not exist.");
        }
        ArticleModel article = this.articleDAO.getById(id);
        article.setType(type);
        this.articleDAO.update(article);
    }

    public void updateStock(Integer stock, int id) throws EntityExistsException, EntityNotFoundException, SQLException{

        if (this.articleDAO.getById(id) == null) {
            throw new EntityNotFoundException("Article does not exist.");
        }
        ArticleModel article = this.articleDAO.getById(id);
        article.setStock(stock);
        this.articleDAO.update(article);
    }

    public void updateDescription(String description,int id) throws EntityExistsException, EntityNotFoundException, SQLException{
        if (this.articleDAO.getById(id) == null) {
            throw new EntityNotFoundException("Article does not exist.");
        }
        ArticleModel article = this.articleDAO.getById(id);
        article.setDescription(description);
        this.articleDAO.update(article);
    }

    public void delete(String name) throws EntityNotFoundException {
        if (this.articleDAO.getArticleByName(name) == null) {
            throw new EntityNotFoundException("User does not exist.");
        }
        ArticleModel user = this.articleDAO.getArticleByName(name);
        this.articleDAO.delete(user);
    }


}
