package com.eceshopping.controllers;

import java.io.IOException;
import java.util.List;

import com.eceshopping.dto.ArticleDto;
import com.eceshopping.services.ArticleService;
import com.eceshopping.views.HomePageView;
import com.eceshopping.views.components.ProductOverviewView;

import javafx.concurrent.Task;
import javafx.scene.Scene;

public class HomePageController implements Controller {
    private final HomePageView view;
    private UserNavBarController navBarController;
    private ArticleService articleService;

    public HomePageController(HomePageView view) {
        this.view = view;
        this.articleService = new ArticleService();
        this.navBarController = new UserNavBarController(this.view.getNavBar());
        loadArticles();
    }

    private void loadArticles() {
        Task<List<ArticleDto>> getAllArticleTask = this.articleService.getAllArticles();
        getAllArticleTask.setOnSucceeded(e -> {
            List<ArticleDto> articles = getAllArticleTask.getValue();
            for (ArticleDto article : articles) {
                ProductOverviewView product = new ProductOverviewView(article.getImage(), article.getName(), article.getPrice(), 0.0); 
                new ProductOverviewController(product);
                this.view.addProduct(product);
            }
            //this.view.loadArticles(articles);
        });
        new Thread(getAllArticleTask).start();
    }

    @Override
    public void bindScene(Scene s) {
        this.view.bindScene(s);
    }
}
