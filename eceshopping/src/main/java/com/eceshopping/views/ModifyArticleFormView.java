package com.eceshopping.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ModifyArticleFormView extends GridPane implements View {

    private Label articleNameLabel;
    private Label articleTypeLabel;
    private Label articlePriceLabel;
    private Label articleBulkPriceLabel;
    private Label articleMarqueLabel;
    private Label articleImageLabel;
    private Label articleStockLabel;

    private Label articleDescriptionLabel;
    private TextField articleNameTextField;
    private TextField bulkpriceTextField;
    private TextField priceTextField;
    private TextField typeTextField;
    private TextField marqueTextField;
    private TextField stockTextField;
    private TextField descriptionTextField;

    private Button addArticleButton;
    private Button addImage;

    private Text titleText;

    private Hyperlink backLink;
    private Text scenetitle;
    private Integer id;

    public ModifyArticleFormView() {

        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        this.scenetitle = new Text("Ajouter un article");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        this.add(scenetitle, 0, 0, 1, 1);

        this.articleNameLabel = new Label("Nom de l'article");
        this.articleNameTextField = new TextField();
        this.add(articleNameLabel, 0, 1, 2, 1);

        this.articleTypeLabel = new Label("Type de l'article");
        this.add(articleTypeLabel, 0, 2, 2, 1);
        this.typeTextField = new TextField();

        this.articlePriceLabel = new Label("Prix de l'article");
        this.add(articlePriceLabel, 0, 3, 2, 1);
        this.priceTextField = new TextField();

        this.articleBulkPriceLabel = new Label("Bulkprice de l'article");
        this.add(articleBulkPriceLabel, 0, 4, 2, 1);
        this.bulkpriceTextField = new TextField();

        this.articleMarqueLabel = new Label("Marque de l'article");
        this.add(articleMarqueLabel, 0, 5, 2, 1);
        this.marqueTextField = new TextField();

        this.articleImageLabel = new Label("Image de l'article");
        this.add(articleImageLabel, 0, 8, 2, 1);
        this.addArticleButton = new Button("Modifier l'article");

        this.articleStockLabel = new Label("Stock de l'article");
        this.add(articleStockLabel, 0, 6, 2, 1);
        this.stockTextField = new TextField();

        this.articleDescriptionLabel = new Label("Description de l'article");
        this.add(articleDescriptionLabel, 0, 7, 2, 1);
        this.descriptionTextField = new TextField();
        this.add(descriptionTextField, 1, 7, 2, 1);

        this.addImage = new Button("Ajouter une image");
        this.add(addImage, 1, 8, 2, 1);

        this.add(bulkpriceTextField, 1, 4, 2, 1);

        this.add(priceTextField, 1, 3, 2, 1);

        this.add(typeTextField, 1, 2, 2, 1);

        this.add(articleNameTextField, 1, 1, 2, 1);

        this.add(marqueTextField, 1, 5, 2, 1);

        this.add(addArticleButton, 1, 9, 2, 1);

        this.add(stockTextField, 1, 6, 2, 1);

        this.backLink = new Hyperlink("Retour");
        this.add(backLink, 0, 9, 1, 1);

    }

    @Override
    public Node getRootNode() {
        return this;
    }

    public Integer getProductId() {
        return id;
    }

    public Label getArticleNameLabel() {
        return articleNameLabel;
    }

    public void setArticleNameLabel(Label articleNameLabel) {
        this.articleNameLabel = articleNameLabel;
    }

    public Label getArticleTypeLabel() {
        return articleTypeLabel;
    }

    public void setArticleTypeLabel(Label articleTypeLabel) {
        this.articleTypeLabel = articleTypeLabel;
    }

    public Label getArticlePriceLabel() {
        return articlePriceLabel;
    }

    public void setArticlePriceLabel(Label articlePriceLabel) {
        this.articlePriceLabel = articlePriceLabel;
    }

    public Label getArticleBulkPriceLabel() {
        return articleBulkPriceLabel;
    }

    public void setArticleBulkPriceLabel(Label articleBulkPriceLabel) {
        this.articleBulkPriceLabel = articleBulkPriceLabel;
    }

    public Label getArticleMarqueLabel() {
        return articleMarqueLabel;
    }

    public void setArticleMarqueLabel(Label articleMarqueLabel) {
        this.articleMarqueLabel = articleMarqueLabel;
    }

    public Label getArticleImageLabel() {
        return articleImageLabel;
    }

    public void setArticleImageLabel(Label articleImageLabel) {
        this.articleImageLabel = articleImageLabel;
    }

    public TextField getArticleNameTextField() {
        return articleNameTextField;
    }

    public TextField getDescriptionTextField() {
        return descriptionTextField;
    }

    public void setArticleNameTextField(TextField articleNameTextField) {
        this.articleNameTextField = articleNameTextField;
    }

    public TextField getBulkpriceTextField() {
        return bulkpriceTextField;
    }

    public void setBulkpriceTextField(TextField bulkpriceTextField) {
        this.bulkpriceTextField = bulkpriceTextField;
    }

    public TextField getPriceTextField() {
        return priceTextField;
    }

    public void setPriceTextField(TextField priceTextField) {
        this.priceTextField = priceTextField;
    }

    public TextField getTypeTextField() {
        return typeTextField;
    }

    public void setTypeTextField(TextField typeTextField) {
        this.typeTextField = typeTextField;
    }

    public TextField getMarqueTextField() {
        return marqueTextField;
    }

    public TextField getStockTextField() {
        return stockTextField;
    }

    public void setStockTextField(TextField stockTextField) {
        this.stockTextField = stockTextField;
    }

    public void setMarqueTextField(TextField marquTextField) {
        this.marqueTextField = marquTextField;
    }

    public Button getModifyArticleButton() {
        return addArticleButton;
    }

    public void setModifyArticleButton(Button addArticleButton) {
        this.addArticleButton = addArticleButton;
    }

    public Text getTitleText() {
        return titleText;
    }

    public void setTitleText(Text titleText) {
        this.titleText = titleText;
    }

    public Hyperlink getBackLink() {
        return backLink;
    }

    public void setBackLink(Hyperlink backLink) {
        this.backLink = backLink;
    }

    public Text getScenetitle() {
        return scenetitle;
    }

    public void setScenetitle(Text scenetitle) {
        this.scenetitle = scenetitle;
    }

    public Button getAddImage() {
        return addImage;
    }

    public void setAddImage(Button addImage) {
        this.addImage = addImage;
    }

}
