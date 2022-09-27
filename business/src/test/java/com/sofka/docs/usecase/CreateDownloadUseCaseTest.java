package com.sofka.docs.usecase;

import com.sofka.docs.commands.CreateDownloadCommand;
import com.sofka.docs.events.DownloadCreated;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
public class CreateDownloadUseCaseTest {
    @InjectMocks
    CreateDownloadUseCase useCase;
    @Test
    void crearDownload() {
        var command = new CreateDownloadCommand();
        command.setDownloadId("down01");
        command.setDocumentId("doc01");
        command.setUserId("user01");
        StepVerifier.create(useCase.apply(Mono.just(command)))
                .expectNextMatches(
                        domainEvent -> {
                            var event = (DownloadCreated) domainEvent;
                            return event.getUserId().value().equals("user01");
                        }
                ).expectComplete()
                .verify();
    }
}
