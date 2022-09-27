package com.sofka.docs;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.values.UserId;

import java.util.List;

public class User extends AggregateEvent<UserId> {

    protected UserId userId;
    protected String email;

    public User(UserId userId, String email) {
        super(userId);
        subscribe(new UserChange(this));
    }

    public static User from(UserId id, String email, List<DomainEvent> events) {
        User user = new User(id, email);
        events.forEach(user::applyEvent);
        return user;
    }
}
