package com.sofka.docdoc.adapters.repo;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docdoc.generic.EventStoreRepository;
import com.sofka.docdoc.gateway.DocumentDomainEventRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class MongoDocumentDomainEventRepository implements DocumentDomainEventRepository {
    private final EventStoreRepository repository;

    public MongoDocumentDomainEventRepository(EventStoreRepository repository) {
        this.repository = repository;
    }


    @Override
    public Flux<DomainEvent> getEventsBy(String id) {
        return repository.getEventsBy("id", id);
    }
}