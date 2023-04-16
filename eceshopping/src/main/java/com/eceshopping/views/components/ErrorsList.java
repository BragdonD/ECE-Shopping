package com.eceshopping.views.components;

import java.util.List;

import com.eceshopping.configs.AppStyles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 * ErrorsList class is used to display a list of errors.
 */
public class ErrorsList extends StackPane {
    private ListView<String> errors; // The list of errors to display

    /**
     * This constructor is used to create a new ErrorsList object.
     * 
     * @param errors The list of errors to display.
     */
    public ErrorsList(List<String> errors) {
        ObservableList<String> errorsList = FXCollections.observableArrayList(errors);
        this.errors = new ListView<String>(errorsList);
        this.errors.setCellFactory(param -> { // Set the style of the list cells
            ListCell<String> cell = new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty && item != null) {
                        setText(item);
                        setStyle(AppStyles.ERROR_TEXT_STYLE);
                    } else {
                        setText(null);
                    }
                }
            };
            return cell;
        });
        // this.errors.setMouseTransparent(true); // Bad idea to enable it
        this.errors.setStyle(AppStyles.TRANSPARENT_BG);
        this.errors.setPrefHeight(errors.size() * 19);
        this.errors.setBorder(
                new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.NONE, null, new BorderWidths(0))));
        this.getChildren().add(this.errors);
        this.setPadding(new Insets(5));
        this.setStyle(AppStyles.TRANSPARENT_BG);
        this.setBorder(
                new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.NONE, null, new BorderWidths(0))));
        this.setHeight(400);
    }
}
