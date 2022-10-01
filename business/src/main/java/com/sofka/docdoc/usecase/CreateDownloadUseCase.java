package com.sofka.docdoc.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docdoc.Download;
import com.sofka.docdoc.commands.CreateDownloadCommand;
import com.sofka.docdoc.values.DocumentId;
import com.sofka.docdoc.values.DownloadId;
import com.sofka.docdoc.values.UserId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
