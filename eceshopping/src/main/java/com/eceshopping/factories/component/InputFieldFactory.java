package com.eceshopping.factories.component;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.components.InputField;
import com.eceshopping.controllers.components.InputFieldController;
import com.eceshopping.models.component.input.InputModel;
import com.eceshopping.utils.validator.Validator;
import com.eceshopping.views.components.input.InputFieldView;

public class InputFieldFactory {
    public static InputField createInputField(InputModel inputModel, Validator validator) {
        InputFieldView inputFieldView = new InputFieldView(inputModel.getLabel(), inputModel.getPlaceholder(),
                inputModel.getType());
        inputFieldView.setStyle(inputModel.getStyle());
        InputFieldController inputFieldController = new InputFieldController(inputFieldView, validator);
        InputField input = new InputField(inputFieldView, inputFieldController);
        return input;
    }

    public static List<InputFieldView> getInputFieldViewListFromInputField(List<InputField> inputFields) {
        List<InputFieldView> inputFieldsView = new ArrayList<InputFieldView>();
        for (InputField inputField : inputFields) {
            inputFieldsView.add(inputField.getView());
        }
        return inputFieldsView;
    }

    public static List<InputFieldController> getInputFieldControllerListFromInputField(List<InputField> inputFields) {
        List<InputFieldController> inputFieldsController = new ArrayList<InputFieldController>();
        for (InputField inputField : inputFields) {
            inputFieldsController.add(inputField.getController());
        }
        return inputFieldsController;
    }
}
