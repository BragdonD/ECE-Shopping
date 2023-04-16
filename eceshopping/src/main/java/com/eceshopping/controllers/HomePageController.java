package com.eceshopping.controllers;

import java.util.List;

import com.eceshopping.dto.ArticleDto;
import com.eceshopping.events.DeleteFromBasketEvent;
import com.eceshopping.events.SearchEvent;
import com.eceshopping.services.ArticleService;
import com.eceshopping.utils.Router;
import com.eceshopping.views.HomePageView;
import com.eceshopping.views.components.ProductOverviewView;

import javafx.concurrent.Task;
import javafx.scene.Scene;

public class HomePageController implements Controller {
    private final HomePageView view;
    private ArticleService articleService;
    private List<ArticleDto> articles;

    /**
     * Constructor for HomePageController
     * 
     * @param view
     */
    public HomePageController(HomePageView view) {
        this.view = view;
        this.articleService = new ArticleService();
        new UserNavBarController(this.view.getNavBar());
        loadArticles();
        setupFilterProducts();

        Router.getInstance().getRouterController().getMainStage()
                .addEventHandler(DeleteFromBasketEvent.DELETE_FROM_CART_EVENT, e -> {
                    ArticleDto article = e.getArticle();
                    Integer quantity = e.getQuantity();
                    if (quantity == 0)
                        return;
                    for (ArticleDto product : this.articles) {
                        if (product.getId() == article.getId())
                            product.setStock(product.getStock() + quantity);
                    }
                });

    }

    private void loadArticles() {
        Task<List<ArticleDto>> getAllArticleTask = this.articleService.getAllArticles();
        getAllArticleTask.setOnSucceeded(e -> {
            this.articles = getAllArticleTask.getValue();
            displayArticles();
            // this.view.loadArticles(articles);
        });
        new Thread(getAllArticleTask).start();
    }

    private void displayArticles() {
        for (ArticleDto article : this.articles) {
            ProductOverviewView product = new ProductOverviewView(article.getImage(), article.getName(),
                    article.getPrice());
            new ProductOverviewController(product, article);
            this.view.addProduct(product);
        }
    }

    private void clearArticles() {
        this.view.clearProducts();
    }

    private void setupFilterProducts() {
        Router.getInstance().getRouterController().getMainStage().addEventHandler(SearchEvent.SEARCH_EVENT, e -> {
            clearArticles();
            for (ArticleDto article : this.articles) {
                if (article.getName().toLowerCase().contains(e.getQuery().toLowerCase())) {
                    ProductOverviewView product = new ProductOverviewView(article.getImage(), article.getName(),
                            article.getPrice());
                    new ProductOverviewController(product, article);
                    this.view.addProduct(product);
                }
            }
        });
    }

    /**
     * @param s
     */
    @Override
    public void bindScene(Scene s) {
        this.view.bindScene(s);
    }
}