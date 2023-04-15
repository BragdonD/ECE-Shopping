package com.eceshopping.controllers;
import com.eceshopping.services.ArticleService;
import com.eceshopping.styles.AppStyles;
import com.eceshopping.utils.Router;
import com.eceshopping.views.components.RemoveArticleFormView;
import javafx.concurrent.Task;
import javafx.scene.Scene;


public class RemoveArticleController implements Controller {
     
    private RemoveArticleFormView view;
    private String name;
   

   ArticleService articleService;

    public  RemoveArticleController(RemoveArticleFormView view) throws IllegalArgumentException {

        this.view = view;
        this.articleService = new ArticleService();
        this.name = "";
        setupRemoveButton();
        setupNameChangeListener();
        setupHyperlink();
        
    }
    private void setupNameChangeListener() {
        this.view.getArticleNameTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            name = newValue.trim();
            if (name.length() > 0) {
                this.view.getArticleNameTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
                //this.view.getArticleNameErrorText().setVisible(false);
            }
        });
    }

    private void setupRemoveButton() {
        this.view.getRemoveArticleButton().setOnAction(e -> {
            if (validateForm())
            {
                       
                        articleService.delete(name);
                       
               
        }
        
        });
    }
   
    private boolean validateForm() {
        boolean valid = true;
        if (name.length() == 0) {
            this.view.getArticleNameTextField().setStyle(AppStyles.TEXT_FIELD_STYLE_ERROR);
            //this.view.getNameErrorText().setVisible(true);
            valid = false;
        }
        return valid;
}

public void setupHyperlink(){
     this.view.getBackButton().setOnAction(e -> {
        Router.getInstance().navigateTo("/adminMenu");
    });
}
public Scene getScene() {
    return this.view.getScene();
}

}