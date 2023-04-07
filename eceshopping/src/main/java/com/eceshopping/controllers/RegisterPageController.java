package com.eceshopping.controllers;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.controllers.components.FormController;
import com.eceshopping.controllers.components.InputFieldController;
import com.eceshopping.dto.UserDto;
import com.eceshopping.services.UserService;
import com.eceshopping.styles.AppStyles;
import com.eceshopping.utils.Router;
import com.eceshopping.utils.validator.EmailValidator;
import com.eceshopping.utils.validator.NotEmptyStringValidator;
import com.eceshopping.utils.validator.PasswordValidator;
import com.eceshopping.views.RegisterPageView;
import com.eceshopping.views.components.InputFieldView;

import javafx.concurrent.Task;
import javafx.scene.text.Text;

public class RegisterPageController implements Controller {
    private RegisterPageView view;
    private FormController registerFormController;
    private UserService userService;
    /**
     * Constructor of the class.
     * 
     * @param view the view of the login form
     **/
    public RegisterPageController(RegisterPageView view) {
        this.view = view;
        this.userService = new UserService();

        List<InputFieldView> inputFieldViews = new ArrayList<InputFieldView>();
        inputFieldViews.add(this.view.getregisterFormView().getNameInputFieldView());
        inputFieldViews.add(this.view.getregisterFormView().getEmailInputFieldView());
        inputFieldViews.add(this.view.getregisterFormView().getPasswordInputFieldView());
        List<InputFieldController> inputFieldsControllers = new ArrayList<InputFieldController>();
        inputFieldsControllers.add(new InputFieldController(inputFieldViews.get(0), new NotEmptyStringValidator()));
        inputFieldsControllers.add(new InputFieldController(inputFieldViews.get(1), new EmailValidator()));
        inputFieldsControllers.add(new InputFieldController(inputFieldViews.get(2), new PasswordValidator()));

        this.registerFormController = new FormController(this.view.getregisterFormView().getFormView(), inputFieldsControllers); 
        
        onSubmit();
        setupRegisterLink();
    }

    /**
     * This method is called when the user click on the submit button of the login form.
     **/
    public void onSubmit() {
        this.registerFormController.addIsSubmittingListener((observable, oldValue, newValue) -> {
            System.out.println("Is submitting: " + newValue);
            if(newValue) {
                String name = this.registerFormController.getinputFieldsController().get(0).getValue();
                String email = this.registerFormController.getinputFieldsController().get(1).getValue();
                String password = this.registerFormController.getinputFieldsController().get(2).getValue();
                
                UserDto user = new UserDto();
                user.setUsername(name);
                user.setEmail(email);
                user.setPassword(password);

                System.out.println(user);

                Task<UserDto> saveUserTask = this.userService.saveUserAsync(user);
                new Thread(saveUserTask).start();

                saveUserTask.setOnSucceeded(event -> {
                    UserDto newUser = saveUserTask.getValue();
                    if(newUser != null) {
                        
                    } else {
                        DisplayError("User already exists");
                        this.registerFormController.reset();
                        return;
                    }
                });

                saveUserTask.setOnFailed(event -> {
                    if(saveUserTask.getException().getMessage() != null) {
                        DisplayError(saveUserTask.getException().getMessage());
                        this.registerFormController.reset();
                        return;
                    }                 
                });
            }
        });
    }
    
    private void DisplayError(String message) {
        if(this.view.getregisterFormView().getFormView().getChildren().size() == 4) {
            this.view.getregisterFormView().getFormView().getChildren().remove(3);
        }
        Text errorText = new Text(message);
        errorText.setStyle(AppStyles.ERROR_TEXT_STYLE);
        this.view.getregisterFormView().getFormView().add(errorText, 0, 4);
    }

    private void setupRegisterLink() {
        this.view.getRegisterButton().setOnAction(event -> {
            System.out.print("Navigate to Login");
            Router.getInstance().navigateTo("/login");
        });
    }
}
