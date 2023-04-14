package com.eceshopping.controllers;

import com.eceshopping.views.components.ManageInvView;
import com.eceshopping.utils.Router;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

public class ManageInvController implements Controller{


    private  ManageInvView view;

    

    public ManageInvController(ManageInvView view) throws IllegalArgumentException {
        this.view =view;

       setupHyperlink();

       
    }
    
    private void setupHyperlink() {
        
        
        this.view.getAddArticleButton().setOnAction(e -> {
            Router.getInstance().navigateTo("/addArticle");
        });
        
        this.view.getRemoveArticleButton().setOnAction(e -> {
            Router.getInstance().navigateTo("/removeArticle");
        });
        
        this.view.getModifyArticleButton().setOnAction(e -> {
            Router.getInstance().navigateTo("/modifyArticle");
        });
    }


}
