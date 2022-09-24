package com.sofka.docs.gateway;

import co.com.sofka.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;

public interface DomainEventsRepository {
    Flux<DomainEvent> obtenerEventosPor(String id);
}
