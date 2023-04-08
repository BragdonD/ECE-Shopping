package com.eceshopping.views.components;

import com.eceshopping.configs.AppStyles;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

public class ProfileMenuButtonLinkView extends ButtonLinkView {
    private Image icon;
    private String title;
    private String description;    
    private GridPane layout;
    GridPane column1;
    GridPane column2;

    public ProfileMenuButtonLinkView() {
        super();
        this.icon = null;
        this.title = "";
        this.description = "";
    }

    public ProfileMenuButtonLinkView(Image icon, String title, String description) {
        super();
        this.icon = icon;
        this.title = title;
        this.description = description;
        initLayout();
        this.getChildren().add(layout);
    }
    
    private void initLayout() {
        this.layout = new GridPane();
        this.column1 = new GridPane();
        this.column2 = new GridPane();
       
        final ImageView image = new ImageView(this.icon);
        image.setFitHeight(50);
        image.setFitWidth(50);
        final HBox box = new HBox();
        box.getChildren().add(image);
        final Text titleText = new Text(this.title);
        final Text descriptionText = new Text(this.description);   
        descriptionText.setWrappingWidth(170);
        descriptionText.setStyle(AppStyles.PROFILE_PAGE_BUTTON_DESCRIPTION_STYLE);
        column1.add(image, 0, 0);
        column1.setAlignment(Pos.CENTER);
        column2.add(titleText, 0, 0);
        column2.add(descriptionText, 0, 1);
        column2.setVgap(10);
        column2.setAlignment(Pos.CENTER);

        layout.add(column1, 0, 0);
        layout.add(column2, 1, 0);
        layout.setHgap(10);
        layout.setPadding(new Insets(15, 10, 15, 10));
    }
}