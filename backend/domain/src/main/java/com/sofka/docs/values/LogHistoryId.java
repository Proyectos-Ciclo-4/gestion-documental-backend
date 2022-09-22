package com.sofka.docs.values;

import co.com.sofka.domain.generic.Identity;

public class LogHistoryId extends Identity {
    public LogHistoryId(String uuid) {
        super(uuid);
    }

    public LogHistoryId() {
    }

    public static LogHistoryId of(String uuid) {return new LogHistoryId(uuid);}
}
