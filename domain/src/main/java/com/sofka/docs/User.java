package com.sofka.docs;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofka.docs.values.UserId;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;

public class User extends AggregateEvent<UserId> {

    protected String name;
    protected String email;
    protected Integer userType;

    /**
     * Instantiates a new Aggregate event.
     *
     * @param entityId the entity id
     */
    public User(UserId entityId) {
        super(entityId);
    }
    //protected

}
