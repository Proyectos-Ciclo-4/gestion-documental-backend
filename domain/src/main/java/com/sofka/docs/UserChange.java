package com.sofka.docs;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.docs.values.UserId;

public class UserChange extends EventChange {
    public UserChange(User user) {
        /*apply((UserVerify event) -> {
            user.userId = UserId.of(event.getId());
            user.email = event.getEmail();
        });*/
    }
}
