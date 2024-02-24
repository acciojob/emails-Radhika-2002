package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        if (oldPassword.equals(password) && newPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
            password = newPassword;
            System.out.println("Password changed successfully!");
        } else {
            System.out.println("Failed to change password. Please make sure the old password is correct and the new password meets the criteria.");
        }
    }
}
