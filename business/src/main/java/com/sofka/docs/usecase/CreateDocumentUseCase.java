package com.sofka.docs.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.Document;
import com.sofka.docs.commands.CreateDocumentCommand;
import com.sofka.docs.values.BlockChainId;
import com.sofka.docs.values.CategoryId;
import com.sofka.docs.values.Descriptiondoc;
import com.sofka.docs.values.DocName;
import com.sofka.docs.values.DocumentId;
import com.sofka.docs.values.PathDocument;
import com.sofka.docs.values.SubcategoryName;
import com.sofka.docs.values.VersionDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

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
                    command.getDateUpdated());
            return document.getUncommittedChanges();
        });
    }
}
