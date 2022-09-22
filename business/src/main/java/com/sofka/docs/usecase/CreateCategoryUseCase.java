package com.sofka.docs.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.CategoryDoc;
import com.sofka.docs.commands.CreateCategoryCommand;
import com.sofka.docs.usecase.gateway.model.DomainEventsRepository;
import com.sofka.docs.values.CategoryId;
import com.sofka.docs.values.CategoryName;
import jdk.jfr.Category;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CreateCategoryUseCase extends UseCaseForCommand<CreateCategoryCommand> {

    private final DomainEventsRepository repository;

    public CreateCategoryUseCase(DomainEventsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<CreateCategoryCommand> createCategoryCommandMono) {
        return createCategoryCommandMono.flatMapMany((command -> repository
                .obtenerEventosPor(command.getCategoryId())
                .collectList()
                .flatMapIterable(events -> {
                    var category = new CategoryDoc(CategoryId.of(command.getCategoryId()), new CategoryName(command.getCategoryName()));
//                    return category.
                    return null;
                })));
    }
}
