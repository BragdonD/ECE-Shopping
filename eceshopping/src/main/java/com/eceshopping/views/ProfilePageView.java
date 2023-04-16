package com.eceshopping.views;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.configs.AppPath;
import com.eceshopping.configs.AppStyles;
import com.eceshopping.configs.AppText;
import com.eceshopping.views.components.ProfileMenuButtonLinkView;
import com.eceshopping.views.layouts.UserLayoutView;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class ProfilePageView extends UserLayoutView implements View {

    private List<ProfileMenuButtonLinkView> buttons;
    private GridPane layout;

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

    
    /** 
     * @return List<ProfileMenuButtonLinkView>
     */
    public List<ProfileMenuButtonLinkView> getButtons() {
        return this.buttons;
    }

    private void initLayout() {
        this.layout = new GridPane();
        int i = 0;
        for (ProfileMenuButtonLinkView button : this.buttons) {
            button.setStyle(AppStyles.PROFILE_PAGE_BUTTON_STYLE);
            this.layout.add(button, 0, i);
            i++;
        }
        this.layout.setVgap(10);
        this.layout.setAlignment(Pos.CENTER);
        this.setSlot(this.layout);
        this.slot.setAlignment(Pos.CENTER);
    }

    
    /** 
     * @return Node
     */
    @Override
    public Node getRootNode() {
        return this;
    }
}