package docdoc.handle;

import docdoc.handle.model.CategoryModel;
import docdoc.handle.model.UserModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class QueryHandle {
    private final ReactiveMongoTemplate template;

    public QueryHandle(ReactiveMongoTemplate template) {
        this.template = template;
    }

    @Bean
    public RouterFunction<ServerResponse> verifyUser() {
        return route(
                GET("/usuario/{email}"),
                request -> template.findOne(filterByEmail(request.pathVariable("email")), UserModel.class, "users")
                        .flatMap(element -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromPublisher(Mono.just(element), UserModel.class)))
        );
    }
    @Bean
    public RouterFunction<ServerResponse> getAllCategories() {
        return route(
                GET("/category/getall"),
                request -> template.findAll (CategoryModel.class, "categories")
                        .collectList()
                        .flatMap(list -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromPublisher(Flux.fromIterable(list), CategoryModel.class)))
        );}

    private Query filterByEmail(String email) {
        return new Query(
                Criteria.where("email").is(email)
        );
    }
}
