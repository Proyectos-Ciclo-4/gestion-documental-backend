package docdoc.adapters.repo;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.gateway.DocumentDomainEventRepository;
import docdoc.generic.EventStoreRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class MongoDocumentDomainEventRepository implements DocumentDomainEventRepository {
    private final EventStoreRepository repository;

    public MongoDocumentDomainEventRepository(EventStoreRepository repository) {
        this.repository = repository;
    }


    @Override
    public Flux<DomainEvent> obtenerEventosPor(String id) {
        return repository.getEventsBy("game", id);
    }

    @Override
    public Flux<DomainEvent> getEventsBy(String id) {
        return null;
    }
}