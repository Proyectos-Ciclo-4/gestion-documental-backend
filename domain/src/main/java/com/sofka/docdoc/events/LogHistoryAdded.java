package com.sofka.docdoc.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docdoc.values.LogHistoryId;

public class LogHistoryAdded extends DomainEvent {
    private final LogHistoryId id;
    public LogHistoryAdded(LogHistoryId id) {
        super("sofka.docs.loghistoryadded");
        this.id = id;
    }

    public LogHistoryId getId() {
        return id;
    }
}
