package com.sofka.docdoc;

import co.com.sofka.domain.generic.EventChange;

public class UserChange extends EventChange {
    public UserChange(User user) {
        /*apply((UserVerify event) -> {
            user.userId = UserId.of(event.getId());
            user.email = event.getEmail();
        });*/
    }
}
