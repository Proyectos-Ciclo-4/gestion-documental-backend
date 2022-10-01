package com.sofka.docdoc.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docdoc.Document;
import com.sofka.docdoc.commands.CreateDocumentCommand;
import com.sofka.docdoc.values.CategoryId;
import com.sofka.docdoc.values.Descriptiondoc;
import com.sofka.docdoc.values.DocName;
import com.sofka.docdoc.values.DocumentId;
import com.sofka.docdoc.values.PathDocument;
import com.sofka.docdoc.values.SubcategoryName;
import com.sofka.docdoc.values.VersionDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CreateDocumentUseCase extends UseCaseForCommand<CreateDocumentCommand> {

    @Override
    public Flux<DomainEvent> apply(Mono<CreateDocumentCommand> crearDocumentcommand) {
        return crearDocumentcommand.flatMapIterable(command -> {

            var document = new Document(DocumentId.of(command.get_id()),
                    new DocName(command.getName()),
                    new CategoryId(command.getCategoryId()),
                    new VersionDocument(command.getVersion()),
                    new PathDocument(command.getPathDocument()),
                    command.getBlockChainId(),
                    new Descriptiondoc(command.getDescription()),
                    new SubcategoryName(command.getSubCategoryName()),
                    command.getDateCreated(),
                    command.getDateCreated(),
                    command.getDateCreated());
            return document.getUncommittedChanges();
        });
    }
}
