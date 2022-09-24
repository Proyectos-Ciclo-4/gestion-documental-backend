package com.sofka.docs.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.CategoryDoc;
import com.sofka.docs.commands.CreateSubCategoryCommand;
import com.sofka.docs.gateway.DocumentDomainEventRepository;
import com.sofka.docs.values.CategoryId;
import com.sofka.docs.values.SubCategory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AddSubcategoryUseCase extends UseCaseForCommand<CreateSubCategoryCommand> {
    private final DocumentDomainEventRepository repository;

    public AddSubcategoryUseCase(DocumentDomainEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<CreateSubCategoryCommand> createSubCategoryCommandMono) {
        return createSubCategoryCommandMono.flatMapMany((command) -> repository
                .getEventsBy(command.getCategoryId())
                .collectList()
                .flatMapIterable(events -> {
                    var category = CategoryDoc.from(CategoryId.of(command.getCategoryId()),events);
                    category.addSubCategory(new SubCategory(command.getSubCategoryName()));
                    //category.setSubCategory(new SubCategory(command.getSubCategoryName()));
                    return category.getUncommittedChanges();
                }));
    }
}
