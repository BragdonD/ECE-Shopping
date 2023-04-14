package com.eceshopping.views;


import com.eceshopping.configs.AppText;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class HomePageView extends GridPane {
    GridPane mainLayout;
    GridPane productControl;
    GridPane productLayout;
    Label title;
    Button alphabeticalSorButton;
    Button priceSortButton;

    public HomePageView()  {
        this.mainLayout = new GridPane();
        this.productLayout = new GridPane();
        this.productControl = new GridPane();
        this.title = new Label(AppText.PRODUCT_PAGE_TITLE);
        this.mainLayout.add(this.title, 0, 0);
        this.mainLayout.add(this.productLayout, 0, 1);
        this.priceSortButton = new Button(AppText.PRODUCT_PAGE_SORT_PRICE);
        this.alphabeticalSorButton = new Button(AppText.PRODUCT_PAGE_SORT_ALPHA);
        this.productControl.add(this.priceSortButton,0,0);
        this.productControl.add(this.alphabeticalSorButton,0,1);
        this.add(this.mainLayout, 1, 0);
        this.add(this.productControl, 0, 0);
    }

    public GridPane getProductLayout() {
        return this.productLayout;
    }
}
