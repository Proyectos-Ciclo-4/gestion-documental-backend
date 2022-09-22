package com.sofka.docs.usecase;


import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.commands.CreateDocumentCommand;
import com.sofka.docs.events.DocumentCreated;
import com.sofka.docs.gateway.DocumentDomainEventRepository;
import com.sofka.docs.values.DocumentId;
import com.sofka.docs.values.LogHistoryId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateDocumentUseCaseTest {
    @Mock
    private DocumentDomainEventRepository repository;
    @InjectMocks
    private CreateDocumentUseCase useCase;

    @Test
    void crearDocument(){
        var command = new CreateDocumentCommand();
        command.setDocumentId("xxx");
        command.setDescription("test descriptiondoc");
        command.setCategoryId("cat01");
        command.setName("NewDoc");
        command.setUserId("user1");
        command.setPathDocument("url");
        command.setVersion(1);
        command.setBlockChainId("blockChainId");

        //command.setCreatedDate(new LocalDate(1980,1,1));
        //command.setCategoryId("cat1");
        //when(repository.getEventsBy("xxx")).thenReturn(history());

        StepVerifier.create(useCase.apply(Mono.just(command)))
                .expectNextMatches(
                        domainEvent -> {
                            var event = (DocumentCreated) domainEvent;
                            return event.getDescription().value().equals("test descriptiondoc");
                            //return  event.getJugadorPrincipal().value().equals("XXX") && event.aggregateRootId().equals("AAAA");
                        }
                ).expectComplete()
                .verify();

    }
    /*private Flux<DomainEvent> history() {
        var event = new DocumentCreated(LogHistoryId.of("xxx"));
        event.setAggregateRootId("xxx");
        return Flux.just(event);
    }*/

}
