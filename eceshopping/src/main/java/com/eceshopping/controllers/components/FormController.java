package com.eceshopping.controllers.components;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.models.component.input.InputModel;
import com.eceshopping.views.components.FormView;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;

public class FormController {
    private FormView view;
    private String name;
    private SimpleBooleanProperty isValid;
    private List<InputFieldController> inputFieldsController;
    private List<ChangeListener<Boolean>> isValidListeners;
    private List<ChangeListener<Boolean>> isSubmitting;

    public FormController(FormView view, List<InputFieldController> inputFieldsController) {
        this.view = view;
        this.isValid = new SimpleBooleanProperty(false);
        this.inputFieldsController = inputFieldsController;
        this.isValidListeners = new ArrayList<ChangeListener<Boolean>>();
        addIsValidListener();
        checkIsValid();
        this.isSubmitting = new ArrayList<ChangeListener<Boolean>>();
        this.view.getSubmitButton().setDisable(!this.isValid.get());
        checkSubmit();
    }

    public FormView getView() {
        return this.view;
    }

    public void setView(FormView view) {
        this.view = view;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<InputFieldController> getinputFieldsController() {
        return this.inputFieldsController;
    }

    public void setinputFieldsController(List<InputFieldController> inputFieldsController) {
        this.inputFieldsController = inputFieldsController;
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

    public FormController view(FormView view) {
        this.view = view;
        return this;
    }

    public FormController name(String name) {
        this.name = name;
        return this;
    }

    public FormController inputFieldsController(List<InputFieldController> inputFieldsController) {
        this.inputFieldsController = inputFieldsController;
        return this;
    }

    public FormController isValid(boolean isValid) {
        this.isValid.set(isValid);
        return this;
    }

    private void addIsValidListener() {
        for (InputFieldController inputField : this.inputFieldsController) {
            inputField.addIsValidChangeListener((observable, oldValue, newValue) -> {
                System.out.println("FormController.addIsValidListener() - " + inputField.getName() + " - " + newValue);
                checkIsValid();
                notifyListeners();
                this.view.getSubmitButton().setDisable(!this.isValid.get());
            });
        }
    }

    private void checkIsValid() {
        Boolean isValid = true;
        for (InputFieldController inputField : this.inputFieldsController) {
            isValid = isValid && inputField.isValid();
        }
        this.isValid.set(isValid);
    }

    public void addIsValidChangeListener(ChangeListener<Boolean> listener) {
        this.isValidListeners.add(listener);
    }

    public void removeIsValidChangeListener(ChangeListener<Boolean> listener) {
        this.isValidListeners.remove(listener);
    }

    public void addIsSubmittingListener(ChangeListener<Boolean> listener) {
        this.isSubmitting.add(listener);
    }

    public void removeIsSubmittingListener(ChangeListener<Boolean> listener) {
        this.isSubmitting.remove(listener);
    }

    public void checkSubmit() {
        this.view.getSubmitButton().setOnAction(e -> {
            System.out.println("FormController.checkSubmit() - Submitting");
            this.isSubmitting.forEach(listener -> {
                listener.changed(this.isValid, false, true);
            });
        });
    }

    public List<InputModel> getValues() {
        List<InputModel> values = new ArrayList<InputModel>();
        for (InputFieldController inputFieldController : this.inputFieldsController) {
            InputModel input = new InputModel();
            input
                    .name(inputFieldController.getName())
                    .value(inputFieldController.getValue())
                    .isValid(inputFieldController.isValid());

            values.add(input);
        }
        return values;
    }

    private void notifyListeners() {
        for(ChangeListener<Boolean> listener : this.isValidListeners) {
            listener.changed(this.isValid, !this.isValid.get(), this.isValid.get());
        }
    }

    public void reset() {
        for (InputFieldController inputFieldController : this.inputFieldsController) {
            inputFieldController.reset();
        }
    }
}
