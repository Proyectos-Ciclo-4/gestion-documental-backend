package com.sofka.docdoc.gateway;

import co.com.sofka.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;

public interface DocumentDomainEventRepository {

    Flux<DomainEvent> getEventsBy(String id);
}
