package com.sofka.docs.events;

import co.com.sofka.domain.generic.DomainEvent;

public class UserVerify extends DomainEvent {

    private String id;
    private String email;

    public UserVerify() {
        super("sofka.docs.userverify");
    }

    public UserVerify(String id, String email) {
        super("sofka.docs.userverify");
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
