package com.eceshopping.controllers;

import java.sql.SQLException;

import com.eceshopping.configs.AppStyles;
import com.eceshopping.dto.ArticleDto;
import com.eceshopping.events.DisplayArticleEvent;
import com.eceshopping.events.ModifyInvEvent;
import com.eceshopping.services.ArticleService;
import com.eceshopping.utils.Router;
import com.eceshopping.views.components.ModifyArticleFormView;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ModifyArticleController implements Controller {
    private ArticleService articleService;
    private final ModifyArticleFormView view;
    private String name;
    private String type;
    private String marque;
    private String description;
    private Double price;
    private Double bulkprice;
    private Image image;
    private int stock;
    ArticleDto article;

    public ModifyArticleController(ModifyArticleFormView view) throws IllegalArgumentException {
        this.view = view;

        this.articleService = new ArticleService();
        this.name = "";
        this.type = "";
        this.marque = "";
        this.price = 0.0;
        this.bulkprice = 0.0;
        this.stock = 0;
        this.image = null;
        this.description = "";

        setupTextFields();
        setupNameChangeListener();
        setupTypeChangeListener();
        setupMarqueChangeListener();
        setupPriceChangeListener();
        setupBulkPriceChangeListener();
        setupButton();
        setupStockChangeListener();
        setupHyperlink();

        Router.getInstance().getRouterController().getMainStage().addEventHandler(DisplayArticleEvent.DISPLAY_ARTICLE,
                e -> {
                    article = e.getArticle();
                });
        // setupImageChangeListener();
        // hideErrorText();
    }

    private void setupNameChangeListener() {
        this.view.getArticleNameTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            name = newValue.trim();
            if (name.length() > 0) {
                this.view.getArticleNameTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
                // this.view.getArticleNameErrorText().setVisible(false);
            }
        });
    }

    private void setupTypeChangeListener() {
        this.view.getTypeTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            type = newValue.trim();
            if (type.length() > 0) {
                this.view.getTypeTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
                // this.view.getTypeErrorText().setVisible(false);
            }
        });
    }

    private void setupMarqueChangeListener() {
        this.view.getMarqueTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            marque = newValue.trim();
            if (marque.length() > 0) {
                this.view.getMarqueTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
                // this.view.getMarqueErrorText().setVisible(false);
            }
        });
    }

    private void setupPriceChangeListener() {
        this.view.getPriceTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            price = Double.parseDouble(newValue);
            if (price > 0) {
                this.view.getPriceTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
                // this.view.getPriceErrorText().setVisible(false);
            }
        });
    }

    private void setupBulkPriceChangeListener() {
        this.view.getBulkpriceTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            bulkprice = Double.parseDouble(newValue);
            if (bulkprice > 0) {
                this.view.getBulkpriceTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
                // this.view.getBulkpriceErrorText().setVisible(false);
            }
        });
    }

    private void setupModifyImageButton() {

        this.view.getAddImage().setOnAction(event -> {
            FileChooser filechooser = new FileChooser();
            filechooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
            Stage stage2 = Router.getInstance().getRouterController().getMainStage();
            java.io.File file = filechooser.showOpenDialog(stage2.getScene().getWindow());
            this.image = new Image(file.getAbsolutePath());
        });
    }

    private void setupModifyButton() {

        this.view.getModifyArticleButton().setOnAction(event -> {

            if (!this.name.isEmpty()) {
                this.name = this.view.getArticleNameTextField().getText();
                articleService.updateName(name, article.getId());
            }
            if (!this.type.isEmpty()) {
                try {
                    articleService.updateType(type, article.getId());
                } catch (EntityExistsException e) {
                    e.printStackTrace();
                } catch (EntityNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (!this.marque.isEmpty()) {
                try {
                    articleService.updateMarque(marque, article.getId());
                } catch (EntityExistsException e) {
                    e.printStackTrace();
                } catch (EntityNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (this.price != 0.0) {
                try {
                    articleService.updatePrice(price, article.getId());
                } catch (EntityExistsException e) {
                    e.printStackTrace();
                } catch (EntityNotFoundException e) {
                    e.printStackTrace();
                }
            }
            if (!this.view.getBulkpriceTextField().getText().isEmpty()) {
                try {
                    articleService.updateBulkprice(bulkprice, article.getId());
                } catch (EntityExistsException e) {
                    e.printStackTrace();
                } catch (EntityNotFoundException e) {
                    e.printStackTrace();
                }
            }
            if (!this.view.getStockTextField().getText().isEmpty()) {
                System.out.println(stock);
                try {
                    articleService.updateStock(stock, article.getId());
                } catch (EntityExistsException e) {
                    e.printStackTrace();
                } catch (EntityNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (!this.view.getDescriptionTextField().getText().isEmpty()) {
                try {
                    articleService.updateDescription(description, article.getId());
                } catch (EntityExistsException e) {
                    e.printStackTrace();
                } catch (EntityNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (this.image != null) {
                System.out.println(image);
                try {
                    articleService.updateImage(image, article.getId());
                } catch (EntityExistsException e) {
                    e.printStackTrace();
                } catch (EntityNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            Router.getInstance().getRouterController().getMainStage().fireEvent(new ModifyInvEvent(this.article));
        });
    }

    private void setupTextFields() {
        this.view.getArticleNameTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
        this.view.getTypeTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
        this.view.getMarqueTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
        this.view.getPriceTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
        this.view.getBulkpriceTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
    }

    /**
     * Setup the change listener for the stock text field
     */

    public void setupStockChangeListener() {
        this.view.getStockTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            stock = Integer.parseInt(newValue);
            if (stock > 0) {
                this.view.getStockTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
            }
        });
    }

    private void setupButton() {

        this.setupModifyImageButton();
        this.setupModifyButton();

    }

    public void setupHyperlink() {
        this.view.getBackLink().setOnAction(e -> {
            Router.getInstance().navigateTo("/adminMenu");
        });
    }

    /**
     * Setup the change listener for the description text field
     */

    public void setupDescriptionChangeListener() {
        this.view.getDescriptionTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            description = newValue.trim();
            if (description.length() > 0) {
                this.view.getDescriptionTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
            }
        });
    }

    /**
     * @return Scene
     */
    public Scene getScene() {
        return this.view.getScene();
    }

    /**
     * @param scene
     */
    @Override
    public void bindScene(Scene scene) {

    }
}
