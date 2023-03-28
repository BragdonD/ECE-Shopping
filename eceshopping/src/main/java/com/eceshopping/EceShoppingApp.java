package com.eceshopping;

import java.util.List;

import com.eceshopping.components.Form;
import com.eceshopping.components.InputField;
import com.eceshopping.configs.FlywayConfig;
import com.eceshopping.controllers.LoginFormController;
import com.eceshopping.controllers.RegisterFormController;
import com.eceshopping.controllers.components.InputFieldController;
import com.eceshopping.factories.component.FormFactory;
import com.eceshopping.factories.component.InputFieldFactory;
import com.eceshopping.models.component.input.InputModel;
import com.eceshopping.utils.Router;
import com.eceshopping.utils.validator.EmailValidator;
import com.eceshopping.utils.validator.PasswordValidator;
import com.eceshopping.views.components.LoginFormView;
import com.eceshopping.views.components.RegisterFormView;
import com.eceshopping.views.components.input.InputFieldView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * JavaFX App class for eceshopping project
 */
public class EceShoppingApp extends Application {
    private Router router;

    @Override
    public void start(@SuppressWarnings("exports") Stage s) {
        GridPane root = new GridPane();
        InputModel test = new InputModel("Email", "Email", "email", "", "Email", "");
        InputModel test2 = new InputModel("Password", "Password", "password", "", "Password", "");
        InputField inputField = InputFieldFactory.createInputField(test, null);
        InputField inputField2 = InputFieldFactory.createInputField(test2, null);
        Form loginForm = FormFactory.createFormFromInputField(List.of(inputField, inputField2), "Submit");
        loginForm.getController().addIsValidChangeListener((observable, oldValue, newValue) -> {
            System.out.println("Is valid: " + newValue);
        });
        root.add(loginForm.getView(), 0, 0);

        s.setTitle("My JavaFX App");
        Scene scene = new Scene(root, 400, 400);
        s.setScene(scene);
        s.show();

        // Set the main stage inside the router controller
        // this.router = Router.getInstance();

        // LoginFormView loginView = new LoginFormView();
        // RegisterFormView registerView = new RegisterFormView();
        // this.router.addRoute("/register", registerView, new
        // RegisterFormController(registerView));
        // this.router.addRoute("/login", loginView, new
        // LoginFormController(loginView));
        // this.router.getRouterController().setMainStage(s);

        // Scene scene = new Scene(this.router.getRootPane(), 400, 400);
        // this.router.getRouterController().setScene(scene);
        // this.router.getRouterController().show();
        // this.router.navigateTo("/login");
    }

    public static void main(String[] args) {
        FlywayConfig.getInstance();
        launch(args);
    }

}
