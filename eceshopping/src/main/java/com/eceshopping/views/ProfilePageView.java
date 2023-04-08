package com.eceshopping.views;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.configs.AppPath;
import com.eceshopping.configs.AppStyles;
import com.eceshopping.configs.AppText;
import com.eceshopping.views.components.ProfileMenuButtonLinkView;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class ProfilePageView extends UserLayoutView implements View {

    private List<ProfileMenuButtonLinkView> buttons;
    private GridPane layout;
    private GridPane column1;
    private GridPane column2;

    private Image image1;
    private Image image2;
    private Image image3;

    public ProfilePageView() {
        this.buttons = new ArrayList<>();
        this.image1 = new Image(AppPath.PATH_IMAGE_PROFILE_PAGE_BUTTON_1);
        this.buttons.add(new ProfileMenuButtonLinkView(this.image1, AppText.PROFILE_PAGE_TITLE_BUTTON_1,
                AppText.PROFILE_PAGE_DESCRIPTION_BUTTON_1));
        this.image2 = new Image(AppPath.PATH_IMAGE_PROFILE_PAGE_BUTTON_2);
        this.buttons.add(new ProfileMenuButtonLinkView(this.image2, AppText.PROFILE_PAGE_TITLE_BUTTON_2,
                AppText.PROFILE_PAGE_DESCRIPTION_BUTTON_2));
        this.image3 = new Image(AppPath.PATH_IMAGE_PROFILE_PAGE_BUTTON_3);
        this.buttons.add(new ProfileMenuButtonLinkView(this.image3, AppText.PROFILE_PAGE_TITLE_BUTTON_3,
                AppText.PROFILE_PAGE_DESCRIPTION_BUTTON_3));
        initLayout();
    }

    public List<ProfileMenuButtonLinkView> getButtons() {
        return this.buttons;
    }

    private void initLayout() {
        this.layout = new GridPane();
        this.column1 = new GridPane();
        this.column1.setVgap(10);
        this.column2 = new GridPane();
        buttons.get(0).setStyle(AppStyles.PROFILE_PAGE_BUTTON_STYLE);
        this.column1.add(buttons.get(0), 0, 0);
        buttons.get(1).setStyle(AppStyles.PROFILE_PAGE_BUTTON_STYLE);
        this.column1.add(buttons.get(1), 0, 1);
        buttons.get(2).setStyle(AppStyles.PROFILE_PAGE_BUTTON_STYLE);
        this.column2.add(buttons.get(2), 0, 0);
        this.layout.add(column1, 0, 0);
        this.layout.add(column2, 1, 0);
        this.layout.setHgap(10);
        this.slot.getChildren().add(this.layout);
    }

    @Override
    public Node getRootNode() {
        return this;
    }
}