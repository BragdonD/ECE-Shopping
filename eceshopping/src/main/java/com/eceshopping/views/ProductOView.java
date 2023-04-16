package com.eceshopping.views;

import java.util.List;

import com.eceshopping.dto.ArticleDto;
import com.eceshopping.services.ArticleService;
import com.eceshopping.configs.AppStyles;

import javafx.concurrent.Task;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class ProductOView extends GridPane {
    private Label title;
    private int row = 0;
    private Button removeProduct;
    private Button editProduct;
    String nomArticle;
    Integer id;

    public ProductOView(String title, Integer id) {
        super();
        this.nomArticle = title;
        this.title = new Label(title);
        this.id = id;
        this.add(this.title, 0, 2);
        this.row = 0;
        this.editProduct = new Button("Edit");
        this.removeProduct = new Button("Remove");
        this.add(this.editProduct, 0, 0);
        this.add(this.removeProduct, 1, 0);
        GridPane lastRow = new GridPane();
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(50);
        lastRow.getColumnConstraints().add(columnConstraints);
        GridPane.setHalignment(this.title, HPos.CENTER);
        this.title.setStyle(AppStyles.PRODUCT_OVERVIEW_TITLE_STYLE);
        this.setStyle(AppStyles.PRODUCT_OVERVIEW_STYLE);
    }

    public Integer getProdId() {
        return this.id;
    }

    public Button getRemoveArticleButton() {
        return this.removeProduct;
    }

    public Button getModifyArticleButton() {
        return this.editProduct;
    }

    public Button getEditArticleButton() {
        return this.editProduct;
    }

    public String getTitle() {
        return this.nomArticle;
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

}
