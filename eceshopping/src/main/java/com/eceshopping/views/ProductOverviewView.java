package com.eceshopping.views;

import java.util.List;

import com.eceshopping.dto.ArticleDto;
import com.eceshopping.services.ArticleService;
import com.eceshopping.styles.AppStyles;

import javafx.concurrent.Task;
import javafx.geometry.HPos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class ProductOverviewView extends GridPane {
    private Label title;
    private int row;
    private Hyperlink removeProduct;
    private Hyperlink editProduct;
    

    public ProductOverviewView( String title) {
        super();
        this.title = new Label(title);
        this.add(this.title, 0, 1);
        this.row = 0;
        this.editProduct = new Hyperlink("Edit");
        this.removeProduct = new Hyperlink("Remove");
this.add(this.editProduct, 0, 2);
        this.add(this.removeProduct, 0, 3);
        GridPane lastRow = new GridPane();
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(50);
        lastRow.getColumnConstraints().add(columnConstraints);
        GridPane.setHalignment(this.title, HPos.CENTER);
        this.title.setStyle(AppStyles.PRODUCT_OVERVIEW_TITLE_STYLE);
        this.setStyle(AppStyles.PRODUCT_OVERVIEW_STYLE);
    }



 

   
}
