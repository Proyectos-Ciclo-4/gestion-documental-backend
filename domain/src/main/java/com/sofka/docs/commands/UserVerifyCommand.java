package com.sofka.docs.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.docs.User;

public class UserVerifyCommand extends Command {

    private String userId;
    private String email;

    public UserVerifyCommand() {
    }

    public UserVerifyCommand(String userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserVerifyCommand{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
