package com.eceshopping.controllers.components;

import com.eceshopping.utils.Router;
import com.eceshopping.views.components.ButtonLinkView;

public class ButtonLinkController {
    protected Router router;
    protected String linkTo;
    protected ButtonLinkView view;
    
    public ButtonLinkController(String to, ButtonLinkView view) {
        this.router = Router.getInstance();
        this.view = view;
        this.view.setOnMouseClicked(e -> {
            this.router.navigateTo(this.linkTo);
        });
    }

    public String getLinkTo() {
        return linkTo;
    }

    public void setLinkTo(String linkTo) {
        this.linkTo = linkTo;
    }

    public ButtonLinkView getView() {
        return view;
    }

    public void setView(ButtonLinkView view) {
        this.view = view;
    }

    public ButtonLinkController view(ButtonLinkView view) {
        setView(view);
        return this;
    }

    public ButtonLinkController linkTo(String linkTo) {
        setLinkTo(linkTo);
        return this;
    }
}