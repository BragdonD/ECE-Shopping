package com.eceshopping.factories.component;

import java.util.List;

import com.eceshopping.components.Form;
import com.eceshopping.components.InputField;
import com.eceshopping.controllers.components.FormController;
import com.eceshopping.controllers.components.InputFieldController;
import com.eceshopping.views.components.FormView;
import com.eceshopping.views.components.InputFieldView;

import javafx.scene.control.Button;

public class FormFactory {
    public static Form createFormFromInputField(List<InputField> inputFields, String submitButtonText) {
        List<InputFieldView> inputFieldsView = InputFieldFactory.getInputFieldViewListFromInputField(inputFields);
        List<InputFieldController> inputFieldsController = InputFieldFactory
                .getInputFieldControllerListFromInputField(inputFields);
        FormView formView = new FormView(inputFieldsView, new Button(submitButtonText));
        FormController formController = new FormController(formView, inputFieldsController);
        Form form = new Form(formView, formController);
        return form;
    }
}
