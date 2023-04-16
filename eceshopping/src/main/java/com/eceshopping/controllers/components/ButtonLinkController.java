package com.eceshopping.controllers.components;

import com.eceshopping.utils.Router;
import com.eceshopping.views.components.ButtonLinkView;

/**
 * Controller class for ButtonLinkView. This class is used to handle
 * the events of the ButtonLinkView.
 */
public class ButtonLinkController {
    protected Router router;
    protected String linkTo;
    protected ButtonLinkView view;

    /**
     * Constructor for ButtonLinkController class.
     * 
     * @param to   The path to navigate to when the button is clicked.
     * @param view The view to be controlled.
     */
    public ButtonLinkController(String to, ButtonLinkView view) {
        this.router = Router.getInstance();
        this.view = view;
        this.linkTo = to;
        this.view.setOnMouseClicked(e -> {
            this.router.navigateTo(this.linkTo);
        });
    }

    /**
     * Get the path to navigate to when the button is clicked.
     * 
     * @return The path to navigate to when the button is clicked.
     */
    public String getLinkTo() {
        return linkTo;
    }

    /**
     * Set the path to navigate to when the button is clicked.
     * 
     * @param linkTo The path to navigate to when the button is clicked.
     */
    public void setLinkTo(String linkTo) {
        this.linkTo = linkTo;
    }

    /**
     * Get the view to be controlled.
     * 
     * @return The view to be controlled.
     */
    public ButtonLinkView getView() {
        return view;
    }

    /**
     * Set the view to be controlled.
     * 
     * @param view The view to be controlled.
     */
    public void setView(ButtonLinkView view) {
        this.view = view;
    }

    /**
     * Set the view to be controlled.
     * 
     * @param view The view to be controlled.
     * @return The controller.
     */
    public ButtonLinkController view(ButtonLinkView view) {
        setView(view);
        return this;
    }

    /**
     * Set the path to navigate to when the button is clicked.
     * 
     * @param linkTo The path to navigate to when the button is clicked.
     * @return The controller.
     */
    public ButtonLinkController linkTo(String linkTo) {
        setLinkTo(linkTo);
        return this;
    }
}