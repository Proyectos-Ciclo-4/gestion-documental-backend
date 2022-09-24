package com.sofka.docs.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.Document;
import com.sofka.docs.commands.DeleteDocumentCommand;
import com.sofka.docs.gateway.DocumentDomainEventRepository;
import com.sofka.docs.values.DocumentId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class DeleteDocumentUseCase extends UseCaseForCommand<DeleteDocumentCommand>{
    private final DocumentDomainEventRepository repository;

    public DeleteDocumentUseCase(DocumentDomainEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<DeleteDocumentCommand> deleteDocumentCommandMono) {
        return deleteDocumentCommandMono.flatMapMany((command) -> repository
                .getEventsBy(command.getDocumentId())
                .collectList()
                .flatMapIterable(events -> {
                    var document = Document.from(DocumentId.of(command.getDocumentId()), events);
                    document.deleteDocument();
                    return document.getUncommittedChanges();
                }));
    }
}
