package com.eceshopping.controllers;

import com.eceshopping.views.components.AdminMenuView;
import com.eceshopping.utils.Router;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

public class AdminMenuController implements Controller{


    private  AdminMenuView view;
    Hyperlink addArticleButton;
    Hyperlink removeArticleButton;
    Hyperlink modifyArticleButton;
    

    public AdminMenuController(AdminMenuView view) throws IllegalArgumentException {
        this.view =view;

       setupHyperlink();

       
    }
    
    private void setupHyperlink() {
        addArticleButton = this.view.getAddArticleButton();
        removeArticleButton = this.view.getRemoveArticleButton();
        modifyArticleButton = this.view.getModifyArticleButton();
        
        addArticleButton.setOnAction(e -> {
            Router.getInstance().navigateTo("/addArticle");
        });
        
        removeArticleButton.setOnAction(e -> {
            Router.getInstance().navigateTo("/removeArticle");
        });
        
        modifyArticleButton.setOnAction(e -> {
            Router.getInstance().navigateTo("/modifyArticle");
        });
    }


}
