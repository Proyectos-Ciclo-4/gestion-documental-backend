package docdoc.handle;


import com.sofka.docs.commands.CreateCategoryCommand;
import com.sofka.docs.commands.CreateDocumentCommand;
import com.sofka.docs.usecase.CreateCategoryUseCase;
import com.sofka.docs.usecase.CreateDocumentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CommandHandle {

    private final ReactiveMongoTemplate template;

    public CommandHandle(ReactiveMongoTemplate template) {
        this.template = template;
    }

    @Bean
    public RouterFunction<ServerResponse> createDocument(CreateDocumentUseCase useCase) {
        return route(
                POST("/document/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> template.save(request.bodyToMono(CreateDocumentCommand.class), "documents")
                        .then(ServerResponse.ok().build())
        );
    }
    @Bean
    public RouterFunction<ServerResponse> createCategory(CreateCategoryUseCase useCase) {
        return route(
                POST("/category/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> template.save(request.bodyToMono(CreateCategoryCommand.class), "categories")
                        .then(ServerResponse.ok().build())
        );
    }
    @Bean
    public RouterFunction<ServerResponse> createSubCategory(CreateCategoryUseCase useCase) {
        return route(
                POST("/category/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> template.save(request.bodyToMono(CreateCategoryCommand.class), "categories")
                        .then(ServerResponse.ok().build())
        );
    }

}