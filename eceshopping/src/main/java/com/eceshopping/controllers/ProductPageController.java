package com.eceshopping.controllers;

import com.eceshopping.dto.ArticleDto;
import com.eceshopping.events.AddToBasketEvent;
import com.eceshopping.events.DisplayProductEvent;
import com.eceshopping.utils.Router;
import com.eceshopping.views.ProductPageView;

import javafx.scene.Scene;

public class ProductPageController implements Controller {
    private ProductPageView view;
    private ArticleDto article;
    private UserNavBarController navBarController;
    
    public ProductPageController(ProductPageView view) {
        this.view = view;
        this.navBarController = new UserNavBarController(this.view.getNavBar());
        listenToEvents();
        setupAddToCartButton();
    }

    private void listenToEvents() {
        Router.getInstance().getRouterController().getMainStage().addEventHandler(DisplayProductEvent.DISPLAY_PRODUCT_EVENT, e -> {
            this.article = e.getArticle();
            System.out.println("Article : " + article);
            this.view.setImage(article.getImage());
            this.view.setName(article.getName());
            this.view.setPrice(Double.toString(article.getPrice()));
            this.view.setDescription("description temporaire");   
            this.view.setQuantity(Integer.toString(article.getStock()));
            this.view.setPriceBulk(Double.toString(article.getBulkprice()));
        });   
    }

    private void setupAddToCartButton() {
        this.view.getAddToCart().setOnAction(e -> {
            Integer wantedQuantity = Integer.parseInt(this.view.getQuantity().getText());
            if(wantedQuantity > article.getStock()) {
                this.view.getQuantity().setStyle("-fx-border-color: red");
                return;
            } else {
                article.setStock(article.getStock() - wantedQuantity);
                this.view.setQuantity(Integer.toString(article.getStock()));
                Router.getInstance().getRouterController().getMainStage().fireEvent(new AddToBasketEvent(article, wantedQuantity));
            }
        });
        this.view.getQuantity().textProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue.matches("\\d*")) {
                this.view.getQuantity().setText(newValue.replaceAll("[^\\d]", ""));
            }
            Integer wantedQuantity = Integer.parseInt(this.view.getQuantity().getText());
            if(wantedQuantity > article.getStock()) {
                this.view.getQuantity().setStyle("-fx-border-color: red");
            } else {
                this.view.getQuantity().setStyle("-fx-border-color: green");
            }
        });
    }

    @Override
    public void bindScene(Scene s) {
        this.view.bindScene(s);
    }
}
