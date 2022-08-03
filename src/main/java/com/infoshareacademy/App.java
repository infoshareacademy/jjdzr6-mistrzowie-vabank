package com.infoshareacademy;
import com.infoshareacademy.service.UserService;

public class App {
    public static void main( String[] args ) throws Exception {
        UserService userService = new UserService();
        userService.showMenu();
    }
}

