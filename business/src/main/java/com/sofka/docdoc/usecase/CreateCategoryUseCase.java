package com.sofka.docdoc.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docdoc.CategoryDoc;
import com.sofka.docdoc.commands.CreateCategoryCommand;
import com.sofka.docdoc.values.CategoryId;
import com.sofka.docdoc.values.CategoryName;
import com.sofka.docdoc.values.UserId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CreateCategoryUseCase extends UseCaseForCommand<CreateCategoryCommand> {
    @Override
    public Flux<DomainEvent> apply(Mono<CreateCategoryCommand> createCategoryCommandMono) {
        return createCategoryCommandMono.flatMapIterable(command -> {
            var category = new CategoryDoc(
                    UserId.of(command.getUserId()),
                    new CategoryId(command.getCategoryId()),
                    new CategoryName(command.getCategoryName())
            );
            //category.addSubCategory(new SubCategory(""));
            return category.getUncommittedChanges();
        });
    }
}
