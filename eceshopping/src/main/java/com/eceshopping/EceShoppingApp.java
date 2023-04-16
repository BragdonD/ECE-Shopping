package com.eceshopping;

import com.eceshopping.configs.FlywayConfig;
import com.eceshopping.controllers.AddArticleFormController;
import com.eceshopping.controllers.AdminMenuController;
import com.eceshopping.controllers.CartPageController;
import com.eceshopping.controllers.HomePageController;
import com.eceshopping.controllers.LoginPageController;
import com.eceshopping.controllers.MainStageController;
import com.eceshopping.controllers.ManageInvController;
import com.eceshopping.controllers.ProductPageController;
import com.eceshopping.controllers.ProfilePageController;
import com.eceshopping.controllers.RegisterPageController;
import com.eceshopping.controllers.UserInformationsPageController;
import com.eceshopping.events.FocusSearchEvent;
import com.eceshopping.events.LooseFocusEvent;
import com.eceshopping.utils.Router;
import com.eceshopping.views.CartPageView;
import com.eceshopping.views.HomePageView;
import com.eceshopping.views.LoginPageView;
import com.eceshopping.views.ProductPageView;
import com.eceshopping.views.ProfilePageView;
import com.eceshopping.views.RegisterPageView;
import com.eceshopping.views.UserInformationsPage;
import com.eceshopping.views.components.AddArticleFormView;
import com.eceshopping.views.components.AdminMenuView;
import com.eceshopping.views.components.ManageInvView;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * JavaFX App class for eceshopping project
 */
public class EceShoppingApp extends Application {
    private Router router;
    private final BooleanProperty ctrlPressed = new SimpleBooleanProperty(false);
    private final BooleanProperty kPressed = new SimpleBooleanProperty(false);

    public static final String APP_NAME = "EceShopping";

    @Override
    public void start(@SuppressWarnings("exports") Stage s) {
        new MainStageController(s);
        this.router = Router.getInstance();
        this.router.getRouterController().setMainStage(s);

        setWindowSize(s);
        s.setTitle(APP_NAME);
        
        Scene scene = new Scene(this.router.getRootPane(), 400, 400);

        addSceneEventHandler(scene, s);

        this.router.getRouterController().setScene(scene);
        this.router.getRouterController().show();

        LoginPageView loginPage = new LoginPageView();
        RegisterPageView registerPage = new RegisterPageView();
        UserInformationsPage userInformationPage = new UserInformationsPage();
        ProfilePageView profilePage = new ProfilePageView();
        HomePageView homePage = new HomePageView();
        ProductPageView productPage = new ProductPageView();
        AdminMenuView AdminMenuView = new AdminMenuView();
        ManageInvView manaInvView = new ManageInvView();
        AddArticleFormView addArticleFormView = new AddArticleFormView();
        CartPageView cartPageView = new CartPageView();

        // Routes for login and register
        this.router.addRoute("/register", registerPage, new RegisterPageController(registerPage));
        this.router.addRoute("/login", loginPage, new LoginPageController(loginPage));

        // Normal routes
        this.router.addRoute("/", homePage, new HomePageController(homePage));
        this.router.addRoute("/cart", cartPageView, new CartPageController(cartPageView));
        this.router.addRoute("/products", productPage, new ProductPageController(productPage));
        this.router.addRoute("/profile", profilePage, new ProfilePageController(profilePage));
        this.router.addRoute("/profile/informations", userInformationPage,
                new UserInformationsPageController(userInformationPage));

        // Routes for admin
        this.router.addRoute("/manageInv", manaInvView, new ManageInvController(manaInvView));
        this.router.addRoute("/addArticle", addArticleFormView, new AddArticleFormController(addArticleFormView));
        //this.router.addRoute("/manageUsers", manageUse)
        this.router.addRoute("/admin", AdminMenuView, new AdminMenuController(AdminMenuView));

        this.router.navigateTo("/");
    }

    public void setWindowSize(@SuppressWarnings("exports") Stage s) {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        int screenWidth = (int) screenBounds.getWidth();
        int screenHeight = (int) screenBounds.getHeight();

        int sceneWidth = 0;
        int sceneHeight = 0;

        if (screenWidth <= 800 && screenHeight <= 600) {
            sceneWidth = 600;
            sceneHeight = 350;
        } else if (screenWidth <= 1280 && screenHeight <= 768) {
            sceneWidth = 1000;
            sceneHeight = 600;
        } else if (screenWidth <= 1920 && screenHeight <= 1080) {
            sceneWidth = 1400;
            sceneHeight = 800;
        }

        s.setWidth(sceneWidth);
        s.setHeight(sceneHeight);
    }

    public void addSceneEventHandler(@SuppressWarnings("exports") Scene scene, @SuppressWarnings("exports") Stage s) {
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.CONTROL)
                ctrlPressed.set(true);
            if (e.getCode() == KeyCode.K)
                kPressed.set(true);
            if (ctrlPressed.get() && kPressed.get()) {
                s.fireEvent(new FocusSearchEvent(true));
            }
            if (e.getCode() == KeyCode.ESCAPE) {
                s.fireEvent(new LooseFocusEvent());
                s.fireEvent(new FocusSearchEvent(false));
            }
        });
    }

    public static void main(String[] args) {
        FlywayConfig.getInstance();
        launch(args);
    }

}