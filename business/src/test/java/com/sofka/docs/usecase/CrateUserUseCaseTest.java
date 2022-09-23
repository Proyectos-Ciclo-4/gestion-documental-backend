package com.sofka.docs.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.commands.UserVerifyCommand;
import com.sofka.docs.events.UserVerify;
import com.sofka.docs.gateway.DomainEventsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CrateUserUseCaseTest {

    @InjectMocks
    private CreateUserUseCase useCase;
    @Mock
    private DomainEventsRepository repository;

    @Test
    void verificarUsuario() {

        var command = new UserVerifyCommand("101", "leonardo@gmail.com");

        when(repository.obtenerEventosPor(command.getUserId())).thenReturn(users());

        StepVerifier.create(useCase.apply(Mono.just(command)))
                .expectNextMatches(domainEvent -> {
                    var event = (UserVerify) domainEvent;
                    assertEquals("leonardo@gmail.com", event.getEmail());
                    return "leonardo@gmail.com".equals(event.getEmail());
                })
                .expectComplete()
                .verify();
    }

    private Flux<DomainEvent> users() {
        return Flux.just(
                new UserVerify("10", "carlos@gmail.com"),
                new UserVerify("101", "leonardo@gmail.com"),
                new UserVerify("23", "Jairo@gmail.com"));
    }

}