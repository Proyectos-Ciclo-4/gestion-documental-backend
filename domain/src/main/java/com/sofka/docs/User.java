package com.sofka.docs;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.events.UserVerify;
import com.sofka.docs.values.UserId;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;

import java.util.List;

public class User extends AggregateEvent<UserId> {

    protected UserId userId;
    protected String email;

    public User(UserId userId, String email) {
        super(userId);
        this.userId = userId;
        this.email = email;
        subscribe(new UserChange(this));
        appendChange(new UserVerify(userId.value(), email)).apply();
    }

    public static User from(UserId id, String email, List<DomainEvent> events) {
        User user = new User(id, email);
        events.forEach(user::applyEvent);
        return user;
    }


}
