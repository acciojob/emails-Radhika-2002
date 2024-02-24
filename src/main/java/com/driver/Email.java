package com.driver;

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
    if (!oldPassword.equals(password)) {
        System.out.println("Failed to change password. Old password is incorrect.");
    } else if (!newPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
        System.out.println("Failed to change password. New password does not meet the criteria.");
    } else {
        password = newPassword;
        System.out.println("Password changed successfully!");
    `}
    }


}
