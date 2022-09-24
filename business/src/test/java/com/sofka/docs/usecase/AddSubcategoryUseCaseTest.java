package com.sofka.docs.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.commands.CreateSubCategoryCommand;
import com.sofka.docs.events.CategoryCreated;
import com.sofka.docs.events.SubCategoryCreated;
import com.sofka.docs.gateway.DocumentDomainEventRepository;
import com.sofka.docs.values.CategoryId;
import com.sofka.docs.values.CategoryName;
import com.sofka.docs.values.UserId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddSubcategoryUseCaseTest {
    @Mock
    private DocumentDomainEventRepository repository;
    @InjectMocks
    private AddSubcategoryUseCase useCase;
    @Test
    void agregarSubacategoria(){
        var command= new CreateSubCategoryCommand();
        command.setCategoryId("Animales");
        command.setSubCategoryName("Domesticos");
        when(repository.getEventsBy("Animales")).thenReturn(history());

        StepVerifier
                .create(useCase.apply(Mono.just(command)))
                .expectNextMatches(domainEvent -> {
                    var event = (SubCategoryCreated) domainEvent;
                    return event.aggregateRootId().equals("Animales");

                })
                .expectComplete()
                .verify();
    }
    private Flux<DomainEvent> history(){
        var event = new CategoryCreated( UserId.of("user1"),
                CategoryId.of("Animales"),
                new CategoryName("Animales"));
        return Flux.just(event);
    }

}