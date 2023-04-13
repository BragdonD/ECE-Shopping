package com.eceshopping.views;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ModifyArticleFormView {
    
    private Label articleNameLabel;
  private Button cherchButton;
    private TextField articleNameTextField;
    private Hyperlink backLink;

    public ModifyArticleFormView() {
        this.articleNameLabel = new Label("Nom de l'article");
        this.articleNameTextField = new TextField();
        this.backLink = new Hyperlink("Retour");
        this.cherchButton = new Button("Chercher");
    }

}
