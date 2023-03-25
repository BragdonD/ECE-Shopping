package com.eceshopping.styles;

/**
 * This class contains all the styles used in the application. 
 * It is used to avoid having the same style in multiple places.
 */
public class AppStyles {

    /**
     * Primary button styles for the application
     */
    public static final String PRIMARY_BUTTON_STYLE_DEACTIVATED = "-fx-background-color: #bfbfbf; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-cursor: hand";
    public static final String PRIMARY_BUTTON_STYLE = "-fx-background-color: #00bfff; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-cursor: hand";
    public static final String PRIMARY_BUTTON_STYLE_HOVER = "-fx-background-color: #009bcf; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-cursor: hand";
    public static final String PRIMARY_BUTTON_STYLE_LOADING = "-fx-background-color: #00bfff; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-cursor: progress; -fx-padding: 0 0 0 20px; -fx-background-position: center left; -fx-background-repeat: no-repeat; -fx-background-image: linear-gradient( to right, white 10%, #00bfff 10%, #00bfff 20%, white 20% ); -fx-animation: spin 2s infinite linear; -fx-animation-play-state: paused;";

    /**
     * Text field styles for the application
     */
    public static final String TEXT_FIELD_STYLE = "-fx-border-radius: 4px; -fx-background-color: white; -fx-border-color: #bfbfbf; -fx-border-width: 1px";
    public static final String TEXT_FIELD_STYLE_ERROR = "-fx-border-radius: 4px; -fx-background-color: wheat; -fx-border-color: red; -fx-border-width: 1px";
    public static final String TEXT_FIELD_STYLE_CORRECT = "-fx-border-radius: 4px; -fx-background-color: #C8E6C9; -fx-border-color: #88D498; -fx-border-width: 1px";

    /**
     * Error Text styles for the application
     */
    public static final String ERROR_TEXT_STYLE = "-fx-fill: red; -fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 0 0 0 5px; -fx-text-alignment: right; -fx-wrap-text: true; -fx-width: 100%;";
}
