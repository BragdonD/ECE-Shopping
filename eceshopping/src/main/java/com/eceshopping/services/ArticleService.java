package com.eceshopping.services;
    
    
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eceshopping.converter.ArticleConverter;

import com.eceshopping.daos.ArticleDao;
import com.eceshopping.dto.ArticleDto;
import com.eceshopping.models.ArticleModel;

//import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import javafx.concurrent.Task;
import javafx.scene.image.Image;

public class ArticleService {

    private ArticleDao articleDAO;

    public ArticleService() {
        this.articleDAO = new ArticleDao();
    }

    public ArticleDto getArticlebyname(String name) throws EntityNotFoundException, IOException {
        return ArticleConverter.convertToDto(articleDAO.getArticleByName(name));
    }

    public Task<ArticleDto> saveArticleAsync(ArticleDto articleDto) {
        Task<ArticleDto> task = new Task<ArticleDto>() {
            @Override
            protected ArticleDto call() throws Exception {
                if(articleDto.getImage() == null) {
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
