package com.eceshopping.views.components;

import java.awt.Label;

import com.eceshopping.views.ProductOverviewView;
import com.eceshopping.views.View;

import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.GridPane;

public class ManageInvView extends GridPane implements View {
    
        private Hyperlink addArticleButton;
        private Hyperlink removeArticleButton;
        private Hyperlink modifyArticleButton;
        private int row = 0;
        GridPane productsLayout;


    

        public ManageInvView() {
            super();
            productsLayout = new GridPane();
            this.addArticleButton = new Hyperlink("Add Article");
            this.removeArticleButton = new Hyperlink("Remove Article");
            this.modifyArticleButton = new Hyperlink("Modify Article");
           
            this.add(this.addArticleButton, 0, 0);
            this.add(this.removeArticleButton, 0, 1);
            this.add(this.modifyArticleButton, 0, 2);
            this.productsLayout.setAlignment(javafx.geometry.Pos.TOP_CENTER);
            this.productsLayout.setPadding(new javafx.geometry.Insets(20.0, 20.0, 20.0, 20.0));
            this.productsLayout.setHgap(20);
            this.productsLayout.setVgap(20);
            this.add(this.productsLayout, 1, 0, 1, 3);
            
            this.row = 0;
        }


      
        public Hyperlink getAddArticleButton() {
            return this.addArticleButton;
        }
        
        public Hyperlink getRemoveArticleButton() {
            return this.removeArticleButton;
        }
        
        public Hyperlink getModifyArticleButton() {
            return this.modifyArticleButton;
        }

    
        public void addProduct(ProductOverviewView product) {
            int col = row % 5; // calculate the column index
            int rowIdx = row / 5; // calculate the row index
            
            this.productsLayout.add(product, col, rowIdx);
            this.row++;
        }

 public GridPane getProductsLayout() {
        return this.productsLayout;
    }
    public void clearProducts() {
        this.productsLayout.getChildren().clear();
        this.row = 0;
    }
        @Override
        public Node getRootNode() {
            // TODO Auto-generated method stub
            return this;
        }

    
    
}
