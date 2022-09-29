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
import java.util.HashSet;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateDocumentUseCaseTest {
    @InjectMocks
    private CreateDocumentUseCase useCase;

    @Test
    void crearDocument() {
        var command = new CreateDocumentCommand();
        command.set_id("test");
        command.setDocumentId("xxx");
        command.setDescription("test descriptiondoc");
        command.setCategoryId("cat01");
        command.setName("NewDoc");
        command.setUserId("user1");
        command.setPathDocument("url");
        command.setVersion(1);
        var array=new HashSet<String>();
        array.add("block");
        command.setBlockChainId(array);
        command.setSubCategoryName("subCategoryName");

        StepVerifier.create(useCase.apply(Mono.just(command)))
                .expectNextMatches(
                        domainEvent -> {
                            var event = (DocumentCreated) domainEvent;
                            return event.getDescription().value().equals("test descriptiondoc");
                        }
                ).expectComplete()
                .verify();

    }
}
