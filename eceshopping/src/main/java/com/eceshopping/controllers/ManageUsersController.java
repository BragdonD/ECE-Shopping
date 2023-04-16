package com.eceshopping.controllers;
import java.util.List;

import com.eceshopping.dto.UserDto;
import com.eceshopping.services.UserService;
import com.eceshopping.utils.Router;
import com.eceshopping.views.components.ManageUserView;
import com.eceshopping.views.components.UserOverView;

import javafx.concurrent.Task;

public class ManageUsersController implements Controller {
    
UserService userService = new UserService();
private ManageUserView view;
private List<UserDto> users;

    public ManageUsersController(ManageUserView view) throws IllegalArgumentException {
        this.view=view;
        this.userService = new UserService();
        setupHyperlink();
    }

    public void loadUsers(){
        Task<List<UserDto>> getAllUserTask = this.userService.getAllUser(); 
        getAllUserTask.setOnSucceeded(e -> {
            this.users = getAllUserTask.getValue();
            displayUsers();
            //this.view.loadUsers(Users);
            System.out.println(this.users);
            
        });
        getAllUserTask.setOnFailed(e -> {
            System.out.println(e.getSource().getException().getMessage());
        });
        new Thread(getAllUserTask).start();
    }
    private void displayUsers() {
        if (this.users == null) {
            return;
        }
        for (UserDto user : this.users) {
            UserOverView userOView = new UserOverView(user.getEmail(),user.getUsername(),user.getAdmin()); 
            new UserOverviewController(userOView,user);
            this.view.addUser(userOView);
        }
    }
    public void setupHyperlink(){
        this.view.getBackLink().setOnAction(e -> {
           Router.getInstance().navigateTo("/adminMenu");
       });
   }
    }

