package com.sofka.docs.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.User;
import com.sofka.docs.commands.UserVerifyCommand;
import com.sofka.docs.usecase.gateway.model.DomainEventsRepository;
import com.sofka.docs.values.UserId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UserVerifyUseCase extends UseCaseForCommand<UserVerifyCommand> {

    private final DomainEventsRepository repository;

    public UserVerifyUseCase(DomainEventsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<UserVerifyCommand> userVerifyCommandMono) {
        return userVerifyCommandMono.flatMapMany((command) -> repository
                .obtenerEventosPor(command.getUserId())
                .collectList()
                .flatMapIterable(events -> {
                    var user = new User(UserId.of(command.getUserId()), command.getEmail());
                    return user.getUncommittedChanges();
                }));
    }
}

