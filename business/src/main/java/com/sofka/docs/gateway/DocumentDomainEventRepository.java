package com.sofka.docs.gateway;

import co.com.sofka.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;

public interface DocumentDomainEventRepository {
    Flux<DomainEvent> obtenerEventosPor(String id);

    Flux<DomainEvent> getEventsBy(String id);
}
