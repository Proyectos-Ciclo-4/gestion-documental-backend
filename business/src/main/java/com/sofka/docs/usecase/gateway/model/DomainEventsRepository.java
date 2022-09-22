package com.sofka.docs.usecase.gateway.model;

import co.com.sofka.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;

public interface DomainEventsRepository {
    Flux<DomainEvent> obtenerEventosPor(String id);
}
