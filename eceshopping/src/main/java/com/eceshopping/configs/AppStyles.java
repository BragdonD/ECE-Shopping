package com.eceshopping.configs;

import javafx.geometry.Dimension2D;

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
    public static final String TEXT_FIELD_STYLE = "-fx-border-radius: 4px; -fx-background-color: white; -fx-border-color: #bfbfbf; -fx-border-width: 1px; -fx-width: 100%; -fx-max-width: 250px ; -fx-padding: 5px; -fx-text-alignment: left; -fx-font-size: 14px; -fx-text-fill: #000000;";
    public static final String TEXT_FIELD_STYLE_ERROR = "-fx-border-radius: 4px; -fx-background-color: wheat; -fx-border-color: red; -fx-border-width: 1px";
    public static final String TEXT_FIELD_STYLE_CORRECT = "-fx-border-radius: 4px; -fx-background-color: #C8E6C9; -fx-border-color: #88D498; -fx-border-width: 1px";

    /**
     * Error Text styles for the application
     */
    public static final String ERROR_TEXT_STYLE = "-fx-fill: red; -fx-text-fill: red; -fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 0 0 0 5px; -fx-text-alignment: right; -fx-wrap-text: true; -fx-width: 100%;";
    public static final String CORRECT_TEXT_STYLE = "-fx-fill: #88D498; -fx-font-size: 12px; -fx-font-weight: bold; -fx-padding: 0 0 0 5px; -fx-text-alignment: right; -fx-wrap-text: true; -fx-width: 100%;";

    public static final String TITLE_STYLE = "-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #000000; -fx-padding: 0 0 0 0px; -fx-text-alignment: center; -fx-wrap-text: true; -fx-width: 100%;";
    public static final String LABEL_STYLE = "-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #000000; -fx-padding: 0 0 1px 0; -fx-text-alignment: center; -fx-wrap-text: true; -fx-width: 100%;";
    public static final String TRANSPARENT_BG = "-fx-background-color: rgba(0,0,0,0);";
    public static final String FORM_STYLE = "-fx-width: 100%; -fx-max-width: 250px ; -fx-padding: 5px; -fx-text-alignment: left; -fx-font-size: 14px; -fx-text-fill: #000000; ";
    public static final String LOGIN_FORM_STYLE = "-fx-background-color: #ffffff; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-color: #bfbfbf; -fx-border-width: 1px; -fx-padding: 20px 20px 20px 20px; -fx-spacing: 10px; -fx-alignment: center; -fx-min-width: 300px; -fx-min-height: 300px;";
    public static final String SUBMIT_BUTTON_STYLE = "-fx-background-color: #00bfff; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-cursor: hand; -fx-padding: 6px 5px 6px 5px; -fx-width: 100%;";
    
    /**
     * Sizes for the application
     */
    public static final int WINDOW_WIDTH_SM = 640;
    public static final int WINDOW_HEIGHT_SM = 480;
    public static final int WINDOW_WIDTH_MD = 768;
    public static final int WINDOW_HEIGHT_MD = 576;
    public static final int WINDOW_WIDTH_LG = 1024;
    public static final int WINDOW_HEIGHT_LG = 768;
    public static final int WINDOW_WIDTH_XL = 1280;
    public static final int WINDOW_HEIGHT_XL = 960;
    public static final int WINDOW_WIDTH_2XL = 1536;
    public static final int WINDOW_HEIGHT_2XL = 1152;
    public static final int WINDOW_WIDTH_3XL = 1920;
    public static final int WINDOW_HEIGHT_3XL = 1440;

    /**
     * 2D Dimension for the application
     */
    public static final Dimension2D WINDOW_SIZE_SM = new Dimension2D(WINDOW_WIDTH_SM, WINDOW_HEIGHT_SM);
    public static final Dimension2D WINDOW_SIZE_MD = new Dimension2D(WINDOW_WIDTH_MD, WINDOW_HEIGHT_MD);
    public static final Dimension2D WINDOW_SIZE_LG = new Dimension2D(WINDOW_WIDTH_LG, WINDOW_HEIGHT_LG);
    public static final Dimension2D WINDOW_SIZE_XL = new Dimension2D(WINDOW_WIDTH_XL, WINDOW_HEIGHT_XL);
    public static final Dimension2D WINDOW_SIZE_2XL = new Dimension2D(WINDOW_WIDTH_2XL, WINDOW_HEIGHT_2XL);
    public static final Dimension2D WINDOW_SIZE_3XL = new Dimension2D(WINDOW_WIDTH_3XL, WINDOW_HEIGHT_3XL);

}