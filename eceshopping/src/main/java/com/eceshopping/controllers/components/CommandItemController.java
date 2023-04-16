package com.eceshopping.controllers.components;

import com.eceshopping.views.components.CommandItemView;

import javafx.stage.Stage;

public class CommandItemController {
    private CommandItemView view;

    public CommandItemController(CommandItemView view) {
        this.view = view;
    }

    private void listenToEvent() {
        this.view.getDisplay().setOnAction(e -> {
            // Stage stage = new Stage();
            // stage.setTitle("Command"); 
            // CommandView commandView = new CommandView();
            // stage.setScene(new Scene(new CommandView().getLayout()));
            // stage.show();
        });
    }
}
