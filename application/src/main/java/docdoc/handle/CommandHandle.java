package docdoc.handle;


import com.sofka.docs.commands.CreateCategoryCommand;
import com.sofka.docs.commands.CreateDocumentCommand;
import com.sofka.docs.commands.CreateSubCategoryCommand;
import com.sofka.docs.commands.DeleteDocumentCommand;
import com.sofka.docs.usecase.AddSubcategoryUseCase;
import com.sofka.docs.usecase.CreateCategoryUseCase;
import com.sofka.docs.usecase.CreateDocumentUseCase;
import com.sofka.docs.usecase.DeleteDocumentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CommandHandle {

    private final ReactiveMongoTemplate template;
    private ErrorHandler errorHandler;

    public CommandHandle(ReactiveMongoTemplate template, ErrorHandler errorHandler) {

        this.template = template;
        this.errorHandler = errorHandler;
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
    public RouterFunction<ServerResponse> createSubCategory(AddSubcategoryUseCase useCase) {
        return route(
                POST("/subcategory/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> template.save(request.bodyToMono(CreateSubCategoryCommand.class), "subcategories")
                        .then(ServerResponse.ok().build())
        );
    }

    //ELIMINAR Documento
    @Bean
    public RouterFunction<ServerResponse> deleteDocument(DeleteDocumentUseCase usecase) {
        return route(
                POST("/document/delete").and(accept(MediaType.APPLICATION_JSON)),
                request -> template.save(request.bodyToMono(DeleteDocumentCommand.class), "documents")
                        .then(ServerResponse.ok().build())
        );
    }

}