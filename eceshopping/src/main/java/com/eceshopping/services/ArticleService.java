package com.eceshopping.services;
    
    
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

    public ArticleDto getArticlebyname(String name) throws EntityNotFoundException {
        return ArticleConverter.convertToDto(articleDAO.getArticleByName(name));
    }

    public Task<ArticleDto> saveArticleAsync(ArticleDto articleDto) {
        Task<ArticleDto> task = new Task<ArticleDto>() {
            @Override
            protected ArticleDto call() throws Exception {
                try {
                    articleDAO.save(ArticleConverter.convertToModel(articleDto));
                } catch (EntityExistsException e) {
                    throw e;
                }
                return null;
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
    public void updateImage(Image image, int id) throws EntityExistsException, EntityNotFoundException{
        if (this.articleDAO.getById(id) == null) {
            throw new EntityNotFoundException("Article does not exist.");
        }
        ArticleModel article = this.articleDAO.getById(id);
        article.setImage(image);
        this.articleDAO.update(article);
    } 
    public void delete(int id) throws EntityNotFoundException {
        if (this.articleDAO.getById(id) == null) {
            throw new EntityNotFoundException("User does not exist.");
        }
        ArticleModel user = this.articleDAO.getById(id);
        this.articleDAO.delete(user);
    }
}
