package com.eceshopping.controllers.components;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.styles.AppStyles;
import com.eceshopping.utils.validator.Validator;
import com.eceshopping.views.components.ErrorsList;
import com.eceshopping.views.components.input.InputFieldView;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.scene.Node;

public class InputFieldController {
    private InputFieldView view;
    private String name;
    private Validator validator;
    private SimpleStringProperty value;
    private SimpleBooleanProperty isValid;
    private List<ChangeListener<Boolean>> listeners;

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

    public InputFieldView getView() {
        return this.view;
    }

    public void setView(InputFieldView view) {
        this.view = view;
    }

    public Validator getValidator() {
        return this.validator;
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SimpleStringProperty valueProperty() {
        return this.value;
    }

    public void setValue(String value) {
        this.value.set(value);
    }

    public SimpleBooleanProperty isValidProperty() {
        return this.isValid;
    }

    public boolean isValid() {
        return this.isValid.get();
    }

    public void setValid(boolean isValid) {
        this.isValid.set(isValid);
    }

    public InputFieldController name(String name) {
        setName(name);
        return this;
    }

    public InputFieldController value(String value) {
        setValue(value);
        return this;
    }

    public InputFieldController isValid(boolean isValid) {
        setValid(isValid);
        return this;
    }

    public InputFieldController view(InputFieldView view) {
        setView(view);
        return this;
    }

    public InputFieldController validator(Validator validator) {
        setValidator(validator);
        return this;
    }
}
