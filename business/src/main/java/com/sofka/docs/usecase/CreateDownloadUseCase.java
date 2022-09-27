package com.sofka.docs.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.Download;
import com.sofka.docs.commands.CreateDownloadCommand;
import com.sofka.docs.values.DocumentId;
import com.sofka.docs.values.DownloadId;
import com.sofka.docs.values.UserId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.time.LocalDateTime;

public class CreateDownloadUseCase extends UseCaseForCommand<CreateDownloadCommand> {
    @Override
    public Flux<DomainEvent> apply(Mono<CreateDownloadCommand> createDownloadCommandMono) {
        return createDownloadCommandMono.flatMapIterable(command -> {
            var download = new Download(
                    DownloadId.of(command.getDownloadId()),
                    UserId.of(command.getUserId()),
                    DocumentId.of(command.getDocumentId()),
                    command.getDownloadsCreated());
            return download.getUncommittedChanges();
        });
    }
}
