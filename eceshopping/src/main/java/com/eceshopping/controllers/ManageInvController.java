package com.eceshopping.controllers;

import com.eceshopping.views.ProductOverviewView;
import com.eceshopping.views.components.ManageInvView;

import java.util.List;

import com.eceshopping.dto.ArticleDto;
import com.eceshopping.services.ArticleService;
import com.eceshopping.utils.Router;

import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

public class ManageInvController implements Controller{


    private  ManageInvView view;

    ArticleService articleService;
    private List<ArticleDto> articles;

    public ManageInvController(ManageInvView view) throws IllegalArgumentException {
        
        this.view =view;
        this.articleService = new ArticleService();
       setupHyperlink();
       loadArticles();
       displayArticles();
    }
    
    private void setupHyperlink() {
        
        
        this.view.getAddArticleButton().setOnAction(e -> {
            Router.getInstance().navigateTo("/addArticle");
        });
        
        this.view.getRemoveArticleButton().setOnAction(e -> {
            Router.getInstance().navigateTo("/removeArticle");
        });
        
        this.view.getModifyArticleButton().setOnAction(e -> {
            Router.getInstance().navigateTo("/modifyArticle");
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
            ProductOverviewView product = new ProductOverviewView(article.getName()); 
            new ProductOverviewController(product);
            this.view.addProduct(product);
        }
    }

    
}
