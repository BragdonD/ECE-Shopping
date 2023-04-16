package com.eceshopping.configs;

/**
 * This class contains all the styles used in the application.
 * It is used to avoid having the same style in multiple places.
 */
public class AppStyles {

        public static final String PRIMARY_BUTTON_STYLE_DEACTIVATED = "" +
                        "-fx-background-color: #bfbfbf;" +
                        " -fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        " -fx-font-weight: bold;" +
                        " -fx-border-radius: 4px;" +
                        " -fx-background-radius: 4px;" +
                        " -fx-cursor: hand";

        public static final String PRIMARY_BUTTON_STYLE = "" +
                        "-fx-background-color: #00bfff;" +
                        " -fx-text-fill: white;" +
                        " -fx-font-size: 14px;" +
                        " -fx-font-weight: bold;" +
                        " -fx-border-radius: 4px;" +
                        " -fx-background-radius: 4px;" +
                        " -fx-cursor: hand";

        public static final String PRIMARY_BUTTON_STYLE_HOVER = "" +
                        "-fx-background-color: #009bcf;" +
                        " -fx-text-fill: white;" +
                        " -fx-font-size: 14px;" +
                        " -fx-font-weight: bold;" +
                        " -fx-border-radius: 4px;" +
                        " -fx-background-radius: 4px;" +
                        " -fx-cursor: hand";
        public static final String PRIMARY_BUTTON_STYLE_LOADING = "" +
                        "-fx-background-color: #00bfff;" +
                        " -fx-text-fill: white;" +
                        " -fx-font-size: 14px;" +
                        " -fx-font-weight: bold;" +
                        " -fx-border-radius: 4px;" +
                        " -fx-background-radius: 4px;" +
                        " -fx-cursor: progress;" +
                        " -fx-padding: 0 0 0 20px;" +
                        " -fx-background-position: center left;" +
                        " -fx-background-repeat: no-repeat;" +
                        " -fx-background-image: linear-gradient( to right, white 10%, #00bfff 10%, #00bfff 20%, white 20% );"
                        +
                        " -fx-animation: spin 2s infinite linear;" +
                        " -fx-animation-play-state: paused;";

        /**
         * Text field styles for the application
         */
        public static final String TEXT_FIELD_STYLE = "" +
                        "-fx-border-radius: 4px;" +
                        " -fx-background-color: white;" +
                        " -fx-border-color: #bfbfbf;" +
                        " -fx-border-width: 1px;" +
                        " -fx-width: 100%;" +
                        " -fx-max-width: 250px ;" +
                        " -fx-padding: 5px;" +
                        " -fx-text-alignment: left;" +
                        " -fx-font-size: 14px;" +
                        " -fx-text-fill: #000000;";
        public static final String TEXT_FIELD_STYLE_ERROR = "" +
                        "-fx-border-radius: 4px;" +
                        " -fx-background-color: wheat;" +
                        " -fx-border-color: red;" +
                        " -fx-border-width: 1px";
        public static final String TEXT_FIELD_STYLE_CORRECT = "" +
                        "-fx-border-radius: 4px;" +
                        " -fx-background-color: #C8E6C9;" +
                        " -fx-border-color: #88D498;" +
                        " -fx-border-width: 1px";

        /**
         * Error Text styles for the application
         */
        public static final String ERROR_TEXT_STYLE = "" +
                        "-fx-fill: red;" +
                        " -fx-text-fill: red;" +
                        " -fx-font-size: 12px;" +
                        " -fx-font-weight: bold;" +
                        " -fx-padding: 0 0 0 5px;" +
                        " -fx-text-alignment: right;" +
                        " -fx-wrap-text: true;" +
                        " -fx-width: 100%;";
        public static final String CORRECT_TEXT_STYLE = "" +
                        "-fx-fill: #88D498;" +
                        " -fx-font-size: 12px;" +
                        " -fx-font-weight: bold;" +
                        " -fx-padding: 0 0 0 5px;" +
                        " -fx-text-alignment: right;" +
                        " -fx-wrap-text: true;" +
                        " -fx-width: 100%;";

        public static final String TITLE_STYLE = "" +
                        "-fx-font-size: 24px;" +
                        " -fx-font-weight: bold;" +
                        " -fx-text-fill: #000000;" +
                        " -fx-padding: 0 0 0 0px;" +
                        " -fx-text-alignment: center;" +
                        " -fx-wrap-text: true;" +
                        " -fx-width: 100%;";
        public static final String LABEL_STYLE = "" +
                        "-fx-font-size: 14px;" +
                        " -fx-font-weight: bold;" +
                        " -fx-text-fill: #000000;" +
                        " -fx-padding: 0 0 1px 0;" +
                        " -fx-text-alignment: center;" +
                        " -fx-wrap-text: true;" +
                        " -fx-width: 100%;";
        public static final String TRANSPARENT_BG = "" +
                        "-fx-background-color: rgba(0,0,0,0);";
        public static final String FORM_STYLE = "" +
                        "-fx-width: 100%;" +
                        " -fx-max-width: 250px;" +
                        " -fx-padding: 5px;" +
                        " -fx-text-alignment: left;" +
                        " -fx-font-size: 14px;" +
                        " -fx-text-fill: #000000;";
        public static final String LOGIN_FORM_STYLE = "" +
                        "-fx-background-color: #ffffff;" +
                        " -fx-border-radius: 4px;" +
                        " -fx-background-radius: 4px;" +
                        " -fx-border-color: #bfbfbf;" +
                        " -fx-border-width: 1px;" +
                        " -fx-padding: 20px 20px 20px 20px;" +
                        " -fx-spacing: 10px;" +
                        " -fx-alignment: center;" +
                        " -fx-min-width: 300px;" +
                        " -fx-min-height: 300px;";
        public static final String SUBMIT_BUTTON_STYLE = "" +
                        "-fx-background-color: #00bfff;" +
                        " -fx-text-fill: white;" +
                        " -fx-font-size: 14px;" +
                        " -fx-font-weight: bold;" +
                        " -fx-border-radius: 4px;" +
                        " -fx-background-radius: 4px;" +
                        " -fx-cursor: hand;" +
                        " -fx-padding: 6px 5px 6px 5px;" +
                        " -fx-width: 100%;";

        public static final String PROFILE_PAGE_BUTTON_STYLE = "-fx-background-color: #f0eded; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 15px; -fx-background-radius: 4px; -fx-cursor: hand; -fx-width: 100%;";
        public static final String PROFILE_PAGE_BUTTON_STYLE_HOVER = "-fx-background-color: #bac4d4; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 15px; -fx-background-radius: 4px; -fx-cursor: hand; -fx-width: 100%;";

        public static final String PROFILE_PAGE_BUTTON_DESCRIPTION_STYLE = "-fx-font-size: 14px; -fx-font-weight: normal; -fx-text-fill: #a6a4a4; -fx-padding: 0 0 0 0px; -fx-text-alignment: left; -fx-wrap-text: true; -fx-width: 100%;";

        public static final String NAVBAR_STYLE = "" +
                        "-fx-background-color: #ffffff;" +
                        "-fx-border-radius: 0px;" +
                        "-fx-background-radius: 0px;" +
                        "-fx-border-color: #bfbfbf;" +
                        "-fx-border-width: 1px;" +
                        "-fx-padding: 10px;" +
                        "-fx-spacing: 0px;" +
                        "-fx-alignment: center;" +
                        "-fx-min-width: 300px;" +
                        "-fx-min-height: 50px;";

        public static final String NAVBAR_BUTTON_STYLE = "" +
                        "-fx-background-color: #ffffff;" +
                        "-fx-text-fill: #000000;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-border-radius: 0px;" +
                        "-fx-background-radius: 0px;" +
                        "-fx-cursor: hand;" +
                        "-fx-padding: 8px;" +
                        "-fx-width: 100%;";

        public static final String NAVBAR_BUTTON_STYLE_HOVER = "" +
                        "-fx-background-color: #f0eded;" +
                        "-fx-text-fill: #000000;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-border-radius: 0px;" +
                        "-fx-background-radius: 0px;" +
                        "-fx-cursor: hand;" +
                        "-fx-padding: 8px;" +
                        "-fx-width: 100%;";

        public static final String PROFILE_INFORMATION_FORM_STYLE = "" +
                        "-fx-background-color: #ffffff;" +
                        "-fx-border-radius: 4px;" +
                        "-fx-background-radius: 4px;" +
                        "-fx-border-color: #bfbfbf;" +
                        "-fx-border-width: 1px;" +
                        "-fx-padding: 20px 20px 20px 20px;" +
                        "-fx-spacing: 10px;" +
                        "-fx-alignment: center;" +
                        "-fx-min-width: 300px;" +
                        "-fx-min-height: 300px;";

        public static final String PROFILE_INFORMATION_FORM_TITLE_STYLE = "" +
                        "-fx-font-size: 25px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #000000;" +
                        "-fx-padding: 0 0 40px 0;" +
                        "-fx-text-alignment: center;" +
                        "-fx-wrap-text: true;" +
                        "-fx-width: 100%;";

        public static final String CANCEL_BUTTON_STYLE = "" +
                        "-fx-background-color: #eb4646;" +
                        "-fx-text-fill: #fff;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-border-radius: 4px;" +
                        "-fx-background-radius: 4px;" +
                        "-fx-cursor: hand;" +
                        "-fx-padding: 5px 15px 5px 15px;" +
                        "-fx-width: 100%;";

        public static final String CANCEL_BUTTON_STYLE_HOVER = "" +
                        "-fx-background-color: #a13030;" +
                        "-fx-text-fill: #fff;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-border-radius: 4px;" +
                        "-fx-background-radius: 4px;" +
                        "-fx-cursor: hand;" +
                        "-fx-padding: 5px 15px 5px 15px;" +
                        "-fx-width: 100%;";

        public static final String SAVE_BUTTON_STYLE = "" +
                        "-fx-background-color: #424fd6;" +
                        "-fx-text-fill: #fff;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-border-radius: 4px;" +
                        "-fx-background-radius: 4px;" +
                        "-fx-cursor: hand;" +
                        "-fx-padding: 5px 15px 5px 15px;" +
                        "-fx-width: 100%;";

        public static final String SAVE_BUTTON_STYLE_HOVER = "" +
                        "-fx-background-color: #242e8c;" +
                        "-fx-text-fill: #fff;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-border-radius: 4px;" +
                        "-fx-background-radius: 4px;" +
                        "-fx-cursor: hand;" +
                        "-fx-padding: 5px 15px 5px 15px;" +
                        "-fx-width: 100%;";

        public static final String EDIT_BUTTON_STYLE_HOVER = "" +
                        "-fx-background-color: #bfbfbf;" +
                        "-fx-text-fill: #000000;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-border-radius: 4px;" +
                        "-fx-background-radius: 4px;" +
                        "-fx-cursor: hand;" +
                        "-fx-padding: 5px 15px 5px 15px;" +
                        "-fx-width: 100%;";

        public static final String EDIT_BUTTON_STYLE = "" +
                        "-fx-background-color: #e3e3e3;" +
                        "-fx-text-fill: #000000;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-border-radius: 4px;" +
                        "-fx-background-radius: 4px;" +
                        "-fx-cursor: hand;" +
                        "-fx-padding: 5px 15px 5px 15px;" +
                        "-fx-width: 100%;";

        public static final String SEARCH_BAR_STYLE = "" +
                        "-fx-background-color: #ffffff;" +
                        "-fx-border-radius: 4px;" +
                        "-fx-background-radius: 4px;" +
                        "-fx-padding: 5px 5px 5px 5px;" +
                        "-fx-spacing: 10px;" +
                        "-fx-alignment: center;" +
                        "-fx-min-width: 300px;";

        public static final String SEARCH_BAR_TEXT_FIELD_STYLE = "" +
                        "-fx-background-color: #ffffff;" +
                        "-fx-border-radius: 4px;" +
                        "-fx-background-radius: 4px;" +
                        "-fx-border-color: #bfbfbf;" +
                        "-fx-border-width: 1px;" +
                        "-fx-padding: 5px 5px 5px 5px;" +
                        "-fx-spacing: 10px;" +
                        "-fx-min-width: 300px;";

        public static final String SEARCH_BAR_TEXT_FIELD_STYLE_HOVER = "" +
                        "-fx-background-color: #ffffff;" +
                        "-fx-border-radius: 4px;" +
                        "-fx-background-radius: 4px;" +
                        "-fx-border-color: #424fd6;" +
                        "-fx-border-width: 1px;" +
                        "-fx-padding: 5px 5px 5px 5px;" +
                        "-fx-spacing: 10px;" +
                        "-fx-min-width: 300px;";

        public static final String SEARCH_BAR_TEXT_FIELD_STYLE_FOCUS = "" +
                        "-fx-background-color: #ffffff;" +
                        "-fx-border-radius: 4px;" +
                        "-fx-background-radius: 4px;" +
                        "-fx-border-color: #424fd6;" +
                        "-fx-border-width: 1px;" +
                        "-fx-padding: 5px 5px 5px 5px;" +
                        "-fx-spacing: 10px;" +
                        "-fx-min-width: 300px;";

        public static final String SEARCH_BAR_BUTTON_STYLE = "" +
                        "-fx-background-color: #424fd6;" +
                        "-fx-text-fill: #fff;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-border-radius: 4px;" +
                        "-fx-background-radius: 4px;" +
                        "-fx-cursor: hand;" +
                        "-fx-padding: 5px 15px 5px 15px;" +
                        "-fx-width: 100%;";

        public static final String SEARCH_BAR_BUTTON_STYLE_HOVER = "" +
                        "-fx-background-color: #242e8c;" +
                        "-fx-text-fill: #fff;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-border-radius: 4px;" +
                        "-fx-background-radius: 4px;" +
                        "-fx-cursor: hand;" +
                        "-fx-padding: 5px 15px 5px 15px;" +
                        "-fx-width: 100%;";

        public static final String PRODUCT_OVERVIEW_STYLE = "" +
                        "-fx-background-color: #ffffff;" +
                        "-fx-border-radius: 15px;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-padding: 5px 5px 5px 5px;" +
                        "-fx-spacing: 10px;" +
                        "-fx-alignment: center;" +
                        "-fx-min-width: 200px;" +
                        "-fx-min-height: 200px;";

        public static final String PRODUCT_OVERVIEW_STYLE_HOVER = "" +
                        "-fx-background-color: #eeeeee;" +
                        "-fx-border-radius: 15px;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-padding: 5px 5px 5px 5px;" +
                        "-fx-spacing: 10px;" +
                        "-fx-alignment: center;" +
                        "-fx-min-width: 200px;" +
                        "-fx-min-height: 200px;" +
                        "-fx-cursor: hand;";

        public static final String PRODUCT_OVERVIEW_TITLE_STYLE = "" +
                        "-fx-border-radius: 4px;" +
                        "-fx-background-radius: 4px;" +
                        "-fx-padding: 5px 5px 5px 5px;" +
                        "-fx-spacing: 10px;" +
                        "-fx-alignment: center;" +
                        "-fx-min-width: 200px;" +
                        "-fx-min-height: 50px;" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #000000;";

        public static final int PRODUCT_HOME_PAGE_NUMBER_OF_COLUMNS = 5;

        public static final String CART_ITEM_STYLE = "" +
                        "-fx-background-color: #ffffff;" +
                        "-fx-border-radius: 15px;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-padding: 5px 5px 5px 5px;" +
                        "-fx-spacing: 10px;" +
                        "-fx-alignment: center;" +
                        "-fx-min-width: 200px;" +
                        "-fx-min-height: 200px;";

        public static final String CART_TOTAL_PRICE_STYLE = "" +
                        "-fx-padding: 5px 5px 5px 5px;" +
                        "-fx-alignment: center;" +
                        "-fx-min-height: 100px;" +
                        "-fx-font-size: 28px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #000000;";
}