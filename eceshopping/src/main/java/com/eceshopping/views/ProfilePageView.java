package com.eceshopping.views;

import java.util.ArrayList;
import java.util.List;
import com.eceshopping.views.components.ProfileMenuButtonLinkView;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;


/// Differencier View and Controller


public class ProfilePageView extends StackPane implements View {

    private List<ProfileMenuButtonLinkView> buttons;
    private GridPane layout;
    private GridPane column1;
    private GridPane column2;

    public static final String PATH_IMAGE_BUTTON_1 = "/images/Box.png";
    public static final String PATH_IMAGE_BUTTON_2 = "/images/Contact.png";
    public static final String PATH_IMAGE_BUTTON_3 = "/images/Info.png";
    
    public static final String TITLE_BUTTON_1 = "My Orders";
    public static final String TITLE_BUTTON_2 = "Contact Us";
    public static final String TITLE_BUTTON_3 = "My informations";
    
    public static final String DESCRIPTION_BUTTON_1 = "VIew your new and old orders";
    public static final String DESCRIPTION_BUTTON_2 = "You can ask us all your questions";
    public static final String DESCRIPTION_BUTTON_3 = "See/Change my informations";

    private Image image1;
    private Image image2;
    private Image image3;

    public ProfilePageView() {
        this.buttons = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(i == 0) {
                this.image1 = new Image(PATH_IMAGE_BUTTON_1);
                this.buttons.add(new ProfileMenuButtonLinkView(this.image1, TITLE_BUTTON_1, DESCRIPTION_BUTTON_1));
            } else if(i == 1) {
                this.image2 = new Image(PATH_IMAGE_BUTTON_2);
                this.buttons.add(new ProfileMenuButtonLinkView(this.image2, TITLE_BUTTON_2, DESCRIPTION_BUTTON_2));
            } else if(i == 2) {
                this.image3 = new Image(PATH_IMAGE_BUTTON_3);
                this.buttons.add(new ProfileMenuButtonLinkView(this.image3, TITLE_BUTTON_3, DESCRIPTION_BUTTON_3));
            }
        }
        initLayout();
        this.getChildren().add(this.layout);
    }

    public List<ProfileMenuButtonLinkView> getButtons() {
        return this.buttons;
    }

    private void initLayout() {
        this.layout = new GridPane();
        this.column1 = new GridPane();
        this.column2 = new GridPane();
        for (int i = 0; i < 2; i++) {
            this.column1.add(buttons.get(i), 0, i);
        }
        this.column2.add(buttons.get(2),0,0);
        this.layout.add(column1, 0, 0);
        this.layout.add(column2, 1, 0);
        this.layout.setHgap(10);
    }    
}