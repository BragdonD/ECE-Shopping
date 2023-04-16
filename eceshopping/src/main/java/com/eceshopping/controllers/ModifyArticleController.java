package com.eceshopping.controllers;

import java.sql.SQLException;

import com.eceshopping.dto.ArticleDto;
import com.eceshopping.events.DisplayArticleEvent;
import com.eceshopping.events.ModifyInvEvent;
import com.eceshopping.factories.ArticleFactory;
import com.eceshopping.services.ArticleService;
import com.eceshopping.configs.AppStyles;
import com.eceshopping.utils.Router;
import com.eceshopping.views.ModifyArticleFormView;
import com.eceshopping.views.ProductOView;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import javafx.concurrent.Task;
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
    private Integer id;
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
        this.id = 0;

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

            if (this.name != null) {
                this.name = this.view.getArticleNameTextField().getText();
                articleService.updateName(name, article.getId());
            }
            if (this.type != null) {
                try {
                    articleService.updateType(type, article.getId());
                } catch (EntityExistsException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (EntityNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (this.marque != null) {
                try {
                    articleService.updateMarque(marque, article.getId());
                } catch (EntityExistsException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (EntityNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (this.price != 0.0) {
                try {
                    articleService.updatePrice(price, article.getId());
                } catch (EntityExistsException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (EntityNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (this.view.getBulkpriceTextField() != null) {
                try {
                    articleService.updateBulkprice(bulkprice, article.getId());
                } catch (EntityExistsException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (EntityNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (this.view.getStockTextField() != null) {
                try {
                    articleService.updateStock(stock, article.getId());
                } catch (EntityExistsException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (EntityNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (this.view.getDescriptionTextField() != null) {
                try {
                    articleService.updateDescription(description, article.getId());
                } catch (EntityExistsException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (EntityNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (this.image != null) {
                System.out.println(image);
                try {
                    articleService.updateImage(image, article.getId());
                } catch (EntityExistsException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (EntityNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
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

    public void setupStockChangeListener() {
        this.view.getStockTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            stock = Integer.parseInt(newValue);
            if (stock > 0) {
                this.view.getStockTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
                // this.view.getQuantityErrorText().setVisible(false);
            }
        });
    }

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

    private void setupButton() {

        this.setupModifyImageButton();
        this.setupModifyButton();

    }

    public void setupHyperlink() {
        this.view.getBackLink().setOnAction(e -> {
            Router.getInstance().navigateTo("/adminMenu");
        });
    }

    public void setupDescriptionChangeListener() {
        this.view.getDescriptionTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            description = newValue.trim();
            if (description.length() > 0) {
                this.view.getDescriptionTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
                // this.view.getMarqueErrorText().setVisible(false);
            }
        });
    }

    public Scene getScene() {
        return this.view.getScene();
    }

    @Override
    public void bindScene(Scene scene) {
        // TODO Auto-generated method stub

    }
}
