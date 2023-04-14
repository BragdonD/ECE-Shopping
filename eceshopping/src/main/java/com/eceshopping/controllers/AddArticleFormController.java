package com.eceshopping.controllers;

import java.io.File;

import com.eceshopping.dto.ArticleDto;
import com.eceshopping.factories.ArticleFactory;
import com.eceshopping.services.ArticleService;
import com.eceshopping.styles.AppStyles;
import com.eceshopping.utils.EmailValidator;
import com.eceshopping.utils.PasswordValidator;
import com.eceshopping.utils.Router;
import com.eceshopping.utils.StringSanitizer;
import com.eceshopping.views.components.AddArticleFormView;
import com.eceshopping.views.components.LoadingCircle;
import com.eceshopping.views.components.RegisterFormView;

import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddArticleFormController implements Controller {
    private ArticleService articleService;
    private final AddArticleFormView view;
    private String name;
    private String type;
    private String marque;
    private Double price;
    private Double bulkprice;
    private Image image;
    private GridPane grid;

    public AddArticleFormController(AddArticleFormView view) throws IllegalArgumentException {
        this.view = view;
        this.articleService = new ArticleService();
        this.name = "";
        this.type = "";
        this.marque = "";
        this.price = 0.0;
        this.bulkprice = 0.0;
        this.image = null;
        setupAddButton();
        setupTextFields();
        setupNameChangeListener();
        setupTypeChangeListener();
        setupMarqueChangeListener();
        setupPriceChangeListener();
        setupBulkPriceChangeListener();

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

    private void setupAddArticleButton() {

        this.view.getAddImage().setOnAction(event -> {
            FileChooser filechooser = new FileChooser();
            filechooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
            Stage stage2 = Router.getInstance().getRouterController().getMainStage();
            java.io.File file = filechooser.showOpenDialog(stage2.getScene().getWindow());
            this.image = new Image(file.getAbsolutePath());
        });
    }

    private void setupButton() {

        this.view.getAddArticleButton().setOnAction(event -> {
            if (validateForm()) {

                ArticleDto articleDto = ArticleFactory.createArticle(name, price, bulkprice, type, marque, this.image);
                System.out.println(articleDto);
                Task<ArticleDto> saveArticleTask = articleService.saveArticleAsync(articleDto);

                saveArticleTask.setOnSucceeded(e -> {
                    System.out.println("Article added successfully");
                });

                saveArticleTask.setOnFailed(e -> {
                    System.out.println("Article not added");
                    System.out.println(saveArticleTask.getException().getMessage());
                    System.out.println("Article not added");
                });

                this.view.getAddArticleButton().setDisable(true);
                this.view.getAddArticleButton().setText("");
                // this.view.getAddArticleButton().setStyle(AppStyles.BUTTON_STYLE);
                this.view.getAddArticleButton().setTooltip(new Tooltip("Add"));
                // this.view.getLoadingCircle().setVisible(true);
                // this.view.getLoadingCircle().start();

                new Thread(saveArticleTask).start();
            }
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
     * private void hideErrorText() {
     * this.view.getNameErrorText().setVisible(false);
     * this.view.getTypeErrorText().setVisible(false);
     * this.view.getMarqueErrorText().setVisible(false);
     * this.view.getPriceErrorText().setVisible(false);
     * this.view.getBulkPriceErrorText().setVisible(false);
     * this.view.getQuantityErrorText().setVisible(false);
     * this.view.getImageErrorText().setVisible(false);
     * }
     */

    private boolean validateForm() {
        boolean valid = true;
        if (name.length() == 0) {
            this.view.getArticleNameTextField().setStyle(AppStyles.TEXT_FIELD_STYLE_ERROR);
            // this.view.getNameErrorText().setVisible(true);
            valid = false;
        }
        if (type.length() == 0) {
            this.view.getTypeTextField().setStyle(AppStyles.TEXT_FIELD_STYLE_ERROR);
            // this.view.getTypeErrorText().setVisible(true);
            valid = false;
        }
        if (marque.length() == 0) {
            this.view.getMarqueTextField().setStyle(AppStyles.TEXT_FIELD_STYLE_ERROR);
            // this.view.getMarqueErrorText().setVisible(true);
            valid = false;
        }
        if (price == 0) {
            this.view.getPriceTextField().setStyle(AppStyles.TEXT_FIELD_STYLE_ERROR);
            // this.view.getPriceErrorText().setVisible(true);
            valid = false;
        }
        if (bulkprice == 0 || bulkprice < 0) {
            this.view.getBulkpriceTextField().setStyle(AppStyles.TEXT_FIELD_STYLE_ERROR);
            // this.view.getBulkpriceErrorText().setVisible(true);
            valid = false;
        }
        return valid;
    }

    private void setupAddButton() {

        this.setupButton();
        this.setupAddArticleButton();

    }

    public Scene getScene() {
        return this.view.getScene();
    }

}
