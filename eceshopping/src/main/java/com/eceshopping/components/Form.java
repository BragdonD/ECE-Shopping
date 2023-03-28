package com.eceshopping.components;

import com.eceshopping.controllers.components.FormController;
import com.eceshopping.views.components.FormView;

public class Form {
    private FormView view;
    private FormController controller;

    public Form(FormView view, FormController controller) {
        this.view = view;
        this.controller = controller;
    }

    public FormView getView() {
        return this.view;
    }

    public void setView(FormView view) {
        this.view = view;
    }

    public FormController getController() {
        return this.controller;
    }

    public void setController(FormController controller) {
        this.controller = controller;
    }

    public Form view(FormView view) {
        this.view = view;
        return this;
    }

    public Form controller(FormController controller) {
        this.controller = controller;
        return this;
    }
}
