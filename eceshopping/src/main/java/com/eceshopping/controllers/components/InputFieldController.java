package com.eceshopping.controllers.components;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.configs.AppStyles;
import com.eceshopping.utils.validator.Validator;
import com.eceshopping.views.components.ErrorsList;
import com.eceshopping.views.components.InputFieldView;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.scene.Node;

/**
 * This class is used to control the input field view
 */
public class InputFieldController {
    private InputFieldView view;
    private String name;
    private Validator validator;
    private SimpleStringProperty value;
    private SimpleBooleanProperty isValid;
    private List<ChangeListener<Boolean>> listeners;

    /**
     * This method is used to check if the input field is valid
     * 
     * @param view      the input field view
     * @param validator the validator used to check if the input field is valid
     */
    public InputFieldController(InputFieldView view, Validator validator) {
        this.view = view;
        this.validator = validator;
        this.value = new SimpleStringProperty("");
        this.isValid = new SimpleBooleanProperty(false);
        this.listeners = new ArrayList<ChangeListener<Boolean>>();
        addTextListener();
        addValueListener();
    }

    /**
     * This method is used to check if the input field is valid
     * 
     * @return the input field view
     */
    public String getValue() {
        return this.value.get();
    }

    /**
     * @param listener
     */
    public void addIsValidChangeListener(ChangeListener<Boolean> listener) {
        this.listeners.add(listener);
    }

    /**
     * @param listener
     */
    public void removeIsValidChangeListener(ChangeListener<Boolean> listener) {
        this.listeners.remove(listener);
    }

    /**
     * This method is used to notify the listeners when the input field validity
     * changes
     */
    private void notifyListeners() {
        for (ChangeListener<Boolean> listener : this.listeners) {
            listener.changed(this.isValid, !this.isValid.get(), this.isValid.get());
        }
    }

    /**
     * This method is used to check if the input field is valid
     */
    private void addTextListener() {
        this.view.getTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            this.value.set(newValue);
        });
    }

    /**
     * This method is used to check if the input field is valid
     */
    private void addValueListener() {
        if (this.validator == null) {
            this.isValid.set(true);
            applyStyle();
            notifyListeners();
            return;
        }
        this.value.addListener((observable, oldValue, newValue) -> {
            Boolean isValid = this.validator.validate(newValue);
            this.isValid.set(isValid);
            ErrorsList errorList = checkForErrorList();
            if (errorList != null) {
                this.view.getChildren().remove(errorList);
            }
            if (!isValid) {
                errorList = new ErrorsList(this.validator.getErrors(value.get()));
                this.view.add(errorList, 0, 3);
            }
            notifyListeners();
            applyStyle();
        });
    }

    /*
     * check if the input field is valid
     */
    private ErrorsList checkForErrorList() {
        ErrorsList errorList = null;
        for (Node node : this.view.getChildren()) {
            if (node.getClass() == ErrorsList.class) {
                errorList = (ErrorsList) node;
                break;
            }
        }
        return errorList;
    }

    /**
     * This method is used to apply the correct style to the input field
     */
    private void applyStyle() {
        if (this.isValid.get()) {
            this.view.getTextField().setStyle(AppStyles.TEXT_FIELD_STYLE_CORRECT);
        } else {
            this.view.getTextField().setStyle(AppStyles.TEXT_FIELD_STYLE_ERROR);
        }
    }

    /**
     * This method is used to get the view of the input field
     */
    public InputFieldView getView() {
        return this.view;
    }

    /**
     * This method is used to set the view of the input field
     */
    public void setView(InputFieldView view) {
        this.view = view;
    }

    /**
     * This method is used to get the validator of the input field
     */
    public Validator getValidator() {
        return this.validator;
    }

    /**
     * This method is used to set the validator of the input field
     */
    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    /**
     * This method is used to get the name of the input field
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method is used to set the name of the input field
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method is used to get the value of the input field
     */
    public SimpleStringProperty valueProperty() {
        return this.value;
    }

    /**
     * This method is used to set the value of the input field
     */
    public void setValue(String value) {
        this.value.set(value);
    }

    /**
     * This method is used to get the isValid property of the input field
     */
    public SimpleBooleanProperty isValidProperty() {
        return this.isValid;
    }

    /**
     * This method is used to get the isValid value of the input field
     */
    public boolean isValid() {
        return this.isValid.get();
    }

    /**
     * This method reset the input field
     */
    public void reset() {
        this.value.set("");
        this.view.getTextField().setText("");
        this.isValid.set(false);
    }

    public InputFieldController validator(Validator validator) {
        this.validator = validator;
        return this;
    }
}
