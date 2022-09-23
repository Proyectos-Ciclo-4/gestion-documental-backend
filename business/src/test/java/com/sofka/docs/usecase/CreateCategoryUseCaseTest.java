package com.sofka.docs.usecase;

import com.sofka.docs.commands.CreateCategoryCommand;
import com.sofka.docs.events.CategoryCreated;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateCategoryUseCaseTest {

    @InjectMocks
    private CreateCategoryUseCase useCase;

    @Test
    void createCategory() {

        var command = new CreateCategoryCommand();
        command.setUserId("101");
        command.setCategoryId("777");
        command.setCategoryName("Graduacion");
        command.setSubcategories(new HashSet<>());

        StepVerifier.create(useCase.apply(Mono.just(command)))
                .expectNextMatches(domainEvent -> {
                    var event = (CategoryCreated) domainEvent;
                    assertEquals("Graduacion", event.getCategoryName().value());
                    return "Graduacion".equals(event.getCategoryName().value());
                })
                .expectComplete()
                .verify();

    }
}