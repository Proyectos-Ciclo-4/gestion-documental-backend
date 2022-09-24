package com.sofka.docs.events;

import co.com.sofka.domain.generic.DomainEvent;

import java.time.LocalDate;

public class DocumentDeleted extends DomainEvent {
    public DocumentDeleted(){
        super("sofka.docs.documentdeleted");
    }

}
