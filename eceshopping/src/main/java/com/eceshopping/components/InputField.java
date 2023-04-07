package com.eceshopping.components;

import com.eceshopping.controllers.components.InputFieldController;
import com.eceshopping.views.components.InputFieldView;

public class InputField {
    private InputFieldView view;
    private InputFieldController controller;

    public InputField(InputFieldView view, InputFieldController controller) {
        this.view = view;
        this.controller = controller;
    }

    public InputFieldView getView() {
        return this.view;
    }

    public void setView(InputFieldView view) {
        this.view = view;
    }

    public InputFieldController getController() {
        return this.controller;
    }

    public void setController(InputFieldController controller) {
        this.controller = controller;
    }

    public InputField view(InputFieldView view) {
        this.view = view;
        return this;
    }

    public InputField controller(InputFieldController controller) {
        this.controller = controller;
        return this;
    }
}
