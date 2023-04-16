package com.eceshopping.views.components;

import com.eceshopping.views.View;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class RemoveArticleFormView extends GridPane implements View {
    private TextField articleNameTextField;
    private Button removeArticleButton;
    private Hyperlink backButton;
    private Text scenetitle;

    public RemoveArticleFormView() {
        super();
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);

        this.scenetitle = new Text("Retirer un article");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        this.articleNameTextField = new TextField();
        this.removeArticleButton = new Button("Remove Article");
        this.backButton = new Hyperlink("Back");

        this.add(this.scenetitle, 1, 0, 2, 1);
        this.add(new Text("Article Name"), 0, 4);
        this.add(this.articleNameTextField, 1, 4);
        this.add(this.removeArticleButton, 3, 6);
        this.add(this.backButton, 0, 10);

    }

    public TextField getArticleNameTextField() {
        return this.articleNameTextField;
    }

    public Button getRemoveArticleButton() {
        return this.removeArticleButton;
    }

    public Hyperlink getBackButton() {
        return this.backButton;
    }

    @Override
    public Node getRootNode() {
        return this;
    }

}