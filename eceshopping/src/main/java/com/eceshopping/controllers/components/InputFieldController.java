package com.eceshopping.controllers.components;

import java.util.ArrayList;

import com.eceshopping.styles.AppStyles;
import com.eceshopping.utils.validator.Validator;
import com.eceshopping.views.components.ErrorsList;
import com.eceshopping.views.components.InputFieldView;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.scene.Node;

public class InputFieldController {
    private InputFieldView view;
    private Validator validator;
    private SimpleStringProperty value;
    private SimpleBooleanProperty isValid;
    private java.util.List<ChangeListener<Boolean>> listeners;

    public InputFieldController(InputFieldView view, Validator validator) {
        this.view = view;
        this.validator = validator;
        this.value = new SimpleStringProperty("");
        this.isValid = new SimpleBooleanProperty(false);
        this.listeners = new ArrayList<ChangeListener<Boolean>>();
        addTextListener();
        addValueListener();
    }

    public String getValue() {
        return this.value.get();
    }

    public void addIsValidChangeListener(ChangeListener<Boolean> listener) {
        this.listeners.add(listener);
    }

    public void removeIsValidChangeListener(ChangeListener<Boolean> listener) {
        this.listeners.remove(listener);
    }

    private void notifyListeners() {
        for(ChangeListener<Boolean> listener : this.listeners) {
            listener.changed(this.isValid, !this.isValid.get(), this.isValid.get());
        }
    }

    private void addTextListener() {
        this.view.getTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            this.value.set(newValue);
        });
    }

    private void addValueListener() {
        this.value.addListener((observable, oldValue, newValue) -> {
            Boolean isValid = this.validator.validate(newValue);
            this.isValid.set(isValid);
            ErrorsList errorList = checkForErrorList();
            if(errorList != null) {
                this.view.getChildren().remove(errorList);
            }
            if(!isValid) {
                errorList = new ErrorsList(this.validator.getErrors(value.get()));
                this.view.add(errorList, 0, 3);
            }
            notifyListeners();
            applyStyle();
        });
    }

    private ErrorsList checkForErrorList() {
        ErrorsList errorList = null;
        for(Node node : this.view.getChildren()) {
            if(node.getClass() == ErrorsList.class) {
                errorList = (ErrorsList)node;
                break;
            }
        }
        return errorList;
    }

    private void applyStyle() {
        if(this.isValid.get()) {
            this.view.getTextField().setStyle(AppStyles.TEXT_FIELD_STYLE_CORRECT);
        } else {
            this.view.getTextField().setStyle(AppStyles.TEXT_FIELD_STYLE_ERROR);
        }
    }
}
