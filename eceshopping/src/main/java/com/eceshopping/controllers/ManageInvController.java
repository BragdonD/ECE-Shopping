package com.eceshopping.controllers;

import com.eceshopping.views.components.ManageInvView;
import com.eceshopping.views.components.ProductOView;

import javafx.concurrent.Task;
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.dto.ArticleDto;
import com.eceshopping.events.DisplayArticleEvent;
import com.eceshopping.events.ModifyInvEvent;
import com.eceshopping.services.ArticleService;
import com.eceshopping.utils.Router;

/**
 * Controller of ManageInvView
 */
public class ManageInvController implements Controller {

    private ManageInvView view;

    ArticleService articleService;
    private List<ArticleDto> articles;
    private List<ProductOviewController> productOviewControllers;
    private ArticleDto article;

    /**
     * Constructor of ManageInvController
     * 
     * @param view
     * @throws IllegalArgumentException
     */
    public ManageInvController(ManageInvView view) throws IllegalArgumentException {
        this.productOviewControllers = new ArrayList<ProductOviewController>();
        this.view = view;
        this.articleService = new ArticleService();
        setupHyperlink();
        loadArticles();
        displayArticles();
        listenToEvents();

    }

    private void setupHyperlink() {

        this.view.getBackLink().setOnAction(e -> {
            Router.getInstance().navigateTo("/adminMenu");
        });
        this.view.getAddArticleButton().setOnAction(e -> {
            Router.getInstance().navigateTo("/addArticle");
        });

    }

    private void loadArticles() {
        Task<List<ArticleDto>> getAllArticleTask = this.articleService.getAllArticles();
        getAllArticleTask.setOnSucceeded(e -> {
            this.articles = getAllArticleTask.getValue();
            displayArticles();
            // this.view.loadArticles(articles);
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
            ProductOView product = new ProductOView(article.getName(), article.getId());
            productOviewControllers.add(new ProductOviewController(product, article));
            this.view.addProduct(product);
        }
    }

    private void listenToEvents() {
        Router.getInstance().getRouterController().getMainStage().addEventHandler(DisplayArticleEvent.DISPLAY_ARTICLE,
                e -> {
                    this.article = e.getArticle();
                    System.out.println("Article : " + article);
                    this.view.setName(article.getName());

                });

        Router.getInstance().getRouterController().getMainStage().addEventHandler(ModifyInvEvent.MODIFY_ARTICLE, e -> {
            ArticleDto articleEvent = e.getArticle();
            System.out.println("Article : " + articleEvent);
            boolean found = false;
            int i = 0;
            for (ArticleDto a : this.articles) {
                if (a.getId() == articleEvent.getId()) {
                    if (e.isDelete()) {
                        this.articles.remove(a);
                        this.view.removeProduct(productOviewControllers.get(i).getView());
                        productOviewControllers.remove(i);
                        found = true;
                        break;
                    }
                    a.setName(articleEvent.getName());
                    a.setMarque(articleEvent.getMarque());
                    a.setPrice(articleEvent.getPrice());
                    a.setBulkprice(articleEvent.getBulkprice());
                    a.setStock(articleEvent.getStock());
                    a.setType(articleEvent.getType());
                    a.setDescription(articleEvent.getDescription());
                    a.setImage(articleEvent.getImage());
                    productOviewControllers.get(i).updateView(articleEvent);
                    found = true;
                    break;
                }
                i++;
            }
            if (!found) {
                this.articles.add(articleEvent);
                ProductOView product = new ProductOView(articleEvent.getName(), articleEvent.getId());
                productOviewControllers.add(new ProductOviewController(product, articleEvent));
                this.view.addProduct(product);
            }
        });

    }

    /**
     * @param scene
     */
    @Override
    public void bindScene(Scene scene) {

    }
}
