package com.infoshareacademy.domain;

public class User {
    private int userId;
    private String userLogin;
    private String userPassword;
    private String userName;
    private String userSurname;
    private String userEmail;
    private int userPhoneNumber;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhoneNumber=" + userPhoneNumber +
                '}';
    }

    public User(int userId, String userLogin, String userPassword, String userName, String userSurname, String userEmail, int userPhoneNumber) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;

    }
}
