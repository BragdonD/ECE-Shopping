package com.eceshopping.controllers;

import com.eceshopping.views.components.ManageInvView;
import com.eceshopping.views.components.ProductOView;

import java.util.List;

import com.eceshopping.dto.ArticleDto;
import com.eceshopping.events.DisplayArticleEvent;
import com.eceshopping.events.ModifyInvEvent;
import com.eceshopping.services.ArticleService;
import com.eceshopping.utils.Router;

import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

public class ManageInvController implements Controller{


    private  ManageInvView view;

    ArticleService articleService;
    private List<ArticleDto> articles;
    private ArticleDto article;

    public ManageInvController(ManageInvView view) throws IllegalArgumentException {
        
        this.view =view;
        this.articleService = new ArticleService();
       setupHyperlink();
       loadArticles();
       displayArticles();
       listenToEvents() ;
       
    }
    
    private void setupHyperlink() {
        this.view.getAddArticleButton().setOnAction(e -> {
            Router.getInstance().navigateTo("/addArticle");
        });
        
    }
    private void loadArticles() {
        Task<List<ArticleDto>> getAllArticleTask = this.articleService.getAllArticles();
        getAllArticleTask.setOnSucceeded(e -> {
            this.articles = getAllArticleTask.getValue();
            displayArticles();
            //this.view.loadArticles(articles);
            System.out.println(this.articles);
            
        });
        getAllArticleTask.setOnFailed(e -> {
            System.out.println(e.getSource().getException().getMessage());
        });
        new Thread(getAllArticleTask).start();
        
    }
    private void displayArticles() {
        if (this.articles == null) {
            return;
        }
        for (ArticleDto article : this.articles) {
            ProductOView product = new ProductOView(article.getName(),article.getId()); 
            new ProductOviewController(product,article);
            this.view.addProduct(product);
        }
    }

    private void listenToEvents() {
        Router.getInstance().getRouterController().getMainStage().addEventHandler(DisplayArticleEvent.DISPLAY_ARTICLE, e -> {
            this.article = e.getArticle();
            System.out.println("Article : " + article);
            this.view.setName(article.getName());

        });  

        Router.getInstance().getRouterController().getMainStage().addEventHandler(ModifyInvEvent.MODIFY_ARTICLE, e -> {
            this.article = e.getArticle();
            System.out.println("Article : " + article);
            this.view.setName(article.getName());

        });
        
    }

    
    
}
