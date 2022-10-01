package com.sofka.docdoc.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docdoc.CategoryDoc;
import com.sofka.docdoc.commands.CreateSubCategoryCommand;
import com.sofka.docdoc.gateway.DocumentDomainEventRepository;
import com.sofka.docdoc.values.CategoryId;
import com.sofka.docdoc.values.SubCategory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CreateSubcategoryUseCase extends UseCaseForCommand<CreateSubCategoryCommand> {
    private final DocumentDomainEventRepository repository;

    public CreateSubcategoryUseCase(DocumentDomainEventRepository repository) {
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
