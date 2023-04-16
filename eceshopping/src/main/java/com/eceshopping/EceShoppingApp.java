package com.eceshopping;

import com.eceshopping.configs.FlywayConfig;
import com.eceshopping.controllers.LoginFormController;
import com.eceshopping.controllers.RegisterFormController;
import com.eceshopping.controllers.AddArticleFormController;
import com.eceshopping.controllers.AdminMenuController;
import com.eceshopping.controllers.ManageInvController;
import com.eceshopping.controllers.ManagePurchaseController;
import com.eceshopping.controllers.ManageUsersController;
import com.eceshopping.controllers.ModifyArticleController;
import com.eceshopping.utils.Router;
import com.eceshopping.views.components.AddArticleFormView;
import com.eceshopping.views.components.AdminMenuView;
import com.eceshopping.views.components.ManageInvView;
import com.eceshopping.views.components.ManagePurchaseView;
import com.eceshopping.views.components.ManageUserView;
import com.eceshopping.views.components.ModifyArticleFormView;
import com.eceshopping.views.components.ProductOView;
import com.eceshopping.views.components.LoginFormView;
import com.eceshopping.views.components.ManageInvView;
import com.eceshopping.views.components.RegisterFormView;




import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App class for eceshopping project 
 */
public class EceShoppingApp extends Application {
    private Router router;

    @Override
    public void start(@SuppressWarnings("exports") Stage s) {
        s.setTitle("My JavaFX App");       
        // Set the main stage inside the router controller
        this.router = Router.getInstance(); 
        this.router.getRouterController().setMainStage(s);

        ManagePurchaseView managePurchaseView = new ManagePurchaseView();
        AdminMenuView adminMenuView = new AdminMenuView();
        ManageInvView manageInvView = new  ManageInvView();
        AddArticleFormView addArticleView = new AddArticleFormView();
        ModifyArticleFormView modifyArticleView = new ModifyArticleFormView();
        LoginFormView loginView = new LoginFormView();
        RegisterFormView registerView = new RegisterFormView();
        ManageUserView manageUserView = new ManageUserView();
        
        //this.router.addRoute("/register", registerView, new RegisterFormController(registerView));
        //this.router.addRoute("/login", loginView, new LoginFormController(loginView));

        this.router.addRoute("/manageInv", manageInvView , new ManageInvController(manageInvView));
        this.router.addRoute("/addArticle", addArticleView, new AddArticleFormController(addArticleView));
        
        this.router.addRoute("/adminMenu", adminMenuView, new AdminMenuController(adminMenuView));
        this.router.addRoute("/modifyArticle", modifyArticleView, new ModifyArticleController(modifyArticleView));
        this.router.addRoute("/manageUsers", manageUserView, new ManageUsersController(manageUserView));
        this.router.addRoute("/manageOrders", managePurchaseView, new ManagePurchaseController(managePurchaseView));
        Scene scene = new Scene(this.router.getRootPane(), 400, 400);
        this.router.getRouterController().setScene(scene);
        this.router.getRouterController().show();
        this.router.navigateTo("/adminMenu");
    }

    public static void main(String[] args) {
        FlywayConfig.getInstance();
        launch(args);
    }

}