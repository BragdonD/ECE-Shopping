package com.eceshopping.controllers.components;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.models.component.input.InputModel;
import com.eceshopping.views.components.FormView;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;

/**
 * This class is used to control the form view and its input fields
 */
public class FormController {
    private FormView view;
    private SimpleBooleanProperty isValid;
    private List<InputFieldController> inputFieldsController;
    private List<ChangeListener<Boolean>> isValidListeners;
    private List<ChangeListener<Boolean>> isSubmitting;

    /*
     * This method is used to check if the form is valid
     */
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

    /**
     * @return List<InputFieldController>
     */
    /*
     * get the form input fields
     */
    public List<InputFieldController> getinputFieldsController() {
        return this.inputFieldsController;
    }

    /**
     * @param inputFieldsController
     */
    /*
     * set the form input fields
     */
    public void setinputFieldsController(List<InputFieldController> inputFieldsController) {
        this.inputFieldsController = inputFieldsController;
    }

    /*
     * Boolean property to check if the form is valid
     */
    public SimpleBooleanProperty isValidProperty() {
        return this.isValid;
    }

    /**
     * This method is check if the form is valid
     */
    public boolean isValid() {
        return this.isValid.get();
    }

    /**
     * set the form is valid
     * 
     * @param isValid the form is valid
     */
    public void setValid(boolean isValid) {
        this.isValid.set(isValid);
    }

    public FormController view(FormView view) {
        this.view = view;
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

    /*
     * This method is used to notify the listeners when the form is valid or not
     */
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

    /*
     * This method checks if the form is valid
     */

    private void checkIsValid() {
        Boolean isValid = true;
        for (InputFieldController inputField : this.inputFieldsController) {
            isValid = isValid && inputField.isValid();
        }
        this.isValid.set(isValid);
    }

    /*
     * add the listener
     */
    public void addIsValidChangeListener(ChangeListener<Boolean> listener) {
        this.isValidListeners.add(listener);
    }

    /*
     * remmove the listener
     */
    public void removeIsValidChangeListener(ChangeListener<Boolean> listener) {
        this.isValidListeners.remove(listener);
    }

    /*
     * This method is used to notify the listeners when the form is valid or not
     */
    public void addIsSubmittingListener(ChangeListener<Boolean> listener) {
        this.isSubmitting.add(listener);
    }

    /*
     * remmove the listener
     */
    public void removeIsSubmittingListener(ChangeListener<Boolean> listener) {
        this.isSubmitting.remove(listener);
    }

    /*
     * This method is used to check if the form is submitting
     */
    public void checkSubmit() {
        this.view.getSubmitButton().setOnAction(e -> {
            System.out.println("FormController.checkSubmit() - Submitting");
            this.isSubmitting.forEach(listener -> {
                listener.changed(this.isValid, false, true);
            });
        });
    }

    /*
     * This method is used to get the form values
     */
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

    /*
     * This method is used to notify the listeners when the form is valid or not
     */
    private void notifyListeners() {
        for (ChangeListener<Boolean> listener : this.isValidListeners) {
            listener.changed(this.isValid, !this.isValid.get(), this.isValid.get());
        }
    }

    /*
     * This method is used to reset the form
     */
    public void reset() {
        for (InputFieldController inputFieldController : this.inputFieldsController) {
            inputFieldController.reset();
        }
    }
}
