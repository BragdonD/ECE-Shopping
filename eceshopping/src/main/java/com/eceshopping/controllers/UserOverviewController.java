package com.eceshopping.controllers;

import com.eceshopping.dto.UserDto;
import com.eceshopping.views.components.UserOverView;

public class UserOverviewController {
    UserDto user;
    private UserOverView view;

    public UserOverviewController(UserOverView view, UserDto user) throws IllegalArgumentException {
        this.view = view;
        this.user = user;
    }

}
