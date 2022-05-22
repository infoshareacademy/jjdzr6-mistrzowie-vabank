package com.infoshareacademy.objects;

public class User {
    static int userId;
    static String userLogin;
    static String userPassword;
    static String userName;
    static String userSurname;
    static String userEmail;
    static int userPhoneNumber;

    public static int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        User.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        User.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        User.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        User.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        User.userSurname = userSurname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        User.userEmail = userEmail;
    }

    public int getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(int userPhoneNumber) {
        User.userPhoneNumber = userPhoneNumber;
    }
}
