package com.sofka.docs.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.CategoryDoc;
import com.sofka.docs.commands.CreateCategoryCommand;
import com.sofka.docs.values.CategoryId;
import com.sofka.docs.values.CategoryName;
import com.sofka.docs.values.SubCategory;
import com.sofka.docs.values.UserId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;

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
