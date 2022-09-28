package docdoc.handle;

import docdoc.handle.model.CategoryModel;
import docdoc.handle.model.DocumentModel;
import docdoc.handle.model.DownloadModel;
import docdoc.handle.model.SubcategoryModel;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class QueryHandle {
    private  ReactiveMongoTemplate template;

    public QueryHandle(ReactiveMongoTemplate template) {
        this.template = template;
    } 

    @Bean
    public RouterFunction<ServerResponse> verifyUser() {
        return route(
                GET("/user/{email}"),
                request -> template.findOne(filterByEmail(request.pathVariable("email")), UserModel.class, "users")
                        .flatMap(element -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromPublisher(Mono.just(element), UserModel.class)))
        );
    }
    @Bean
    public RouterFunction<ServerResponse> getSubcategories() {
        return route(
                GET("/subcategory/{categoryId}"),
                request -> template.find(filterByCategory(request.pathVariable("categoryId")), SubcategoryModel.class, "subcategories")
                        .collectList()
                        .flatMap(list -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromPublisher(Flux.fromIterable(list), SubcategoryModel.class)))
        );
    }
    @Bean
    public RouterFunction<ServerResponse> getSubcategoryByFilterToCompare() {
        return route(
                GET("/subcategory/compare/{categoryId}/{subcategory}"),
                request -> template.find(filterByCategoryAndSubCategory(request.pathVariable("categoryId"),request.pathVariable("subcategory")),SubcategoryModel.class, "subcategories")
                        .collectList()
                        .flatMap(list -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromPublisher(Flux.fromIterable(list), SubcategoryModel.class)))
        );}
    @Bean
    public RouterFunction<ServerResponse> getCategoryToCompare() {
        return route(
                GET("/category/compare/{categoryName}"),
                request -> template.find(filterCategoryByName(request.pathVariable("categoryName")), CategoryModel.class, "categories")
                        .collectList()
                        .flatMap(list -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromPublisher(Flux.fromIterable(list), CategoryModel.class)))
        );
    }
    @Bean
    public RouterFunction<ServerResponse> getAllCategories() {
        return route(
                GET("/category/getall"),
                request -> template.findAll(CategoryModel.class, "categories")
                        .collectList()
                        .flatMap(list -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromPublisher(Flux.fromIterable(list), CategoryModel.class)))
        );}
    @Bean
    public RouterFunction<ServerResponse> getDocumentByCategoryIdAndSubCategoryName() {
        return route(
                GET("/documents/{categoryId}/{subcategory}"),
                request -> template.find(filterByCategoryAndSubCategory(request.pathVariable("categoryId"),request.pathVariable("subcategory")),DocumentModel.class, "documents")
                        .collectList()
                        .flatMap(list -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromPublisher(Flux.fromIterable(list), DocumentModel.class)))
        );}
    @Bean
    public RouterFunction<ServerResponse> getDocumentByCategoryIdAndSubCategoryNull() {
        return route(
                GET("/document/{categoryId}"),
                request -> template.find(filterByCategoryAndSubCategoryNull(request.pathVariable("categoryId")),DocumentModel.class, "documents")
                        .collectList()
                        .flatMap(list -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromPublisher(Flux.fromIterable(list), DocumentModel.class)))
        );}
    @Bean
    public RouterFunction<ServerResponse> getDocumentsByCategory() {
        return route(
                GET("/documents/{categoryId}"),
                request -> template.find(filterByCategory(request.pathVariable("categoryId")), DocumentModel.class, "documents")
                        .collectList()
                        .flatMap(list -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromPublisher(Flux.fromIterable(list), DocumentModel.class)))
        );
    }
    @Bean
    public RouterFunction<ServerResponse> getAllDocuments() {
        return route(
                GET("/documents/getall"),
                request -> template.findAll(DocumentModel.class, "documents")
                        .collectList()
                        .flatMap(list -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromPublisher(Flux.fromIterable(list), DocumentModel.class)))
        );}

    @Bean
    public RouterFunction<ServerResponse> getAllDownloads() {
        return route(
                GET("/downloads/getall"),
                request -> template.findAll(DownloadModel.class, "downloads")
                        .collectList()
                        .flatMap(list -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromPublisher(Flux.fromIterable(list), DownloadModel.class)))
        );}

    @Bean
    public RouterFunction<ServerResponse> getDownloadsByTimePeriod() {
        return route(
                GET("/downloads/{startDate}/{finalDate}"),
                request -> template.find(filterByTimePeriod(LocalDate.parse(request.pathVariable("startDate")),
                                LocalDate.parse(request.pathVariable("finalDate"))),DownloadModel.class, "downloads")
                        .collectList()
                        .flatMap(list -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromPublisher(Flux.fromIterable(list), DownloadModel.class)))
        );}
    @Bean
    public RouterFunction<ServerResponse> getDocumentsById() {
        return route(
                GET("/documento/{id}"),
                request -> template.findOne(filterById(request.pathVariable("id")), DocumentModel.class, "documents")
                        .flatMap(element -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromPublisher(Mono.just(element), DocumentModel.class)))
        );
    }
    private Query filterByEmail(String email) {
        return new Query(
                Criteria.where("email").is(email)
        );}
    private Query filterCategoryByName(String categoryName) {
        return new Query(
                Criteria.where("categoryName").is(categoryName)
        );}
    private Query filterByCategoryAndSubCategory(String category, String subcategory) {
        return new Query(
                Criteria.where("categoryId").is(category).and("subCategoryName").is(subcategory)
        );}
    private Query filterByCategoryAndSubCategoryNull(String category) {
        return new Query(
                Criteria.where("categoryId").is(category).and("subCategoryName").is("")
        );}
    private Query filterByUuid(String uuid) {
        return new Query(Criteria.where("id").is(uuid));}

    private Query filterByCategory(String categoryId) {
        return new Query(Criteria.where("categoryId").is(categoryId));
    }
    private Query filterByTimePeriod(LocalDate dateOne, LocalDate dateTwo) {
        return new Query(
                //Criteria.where("downloadsCreated").is(dateOne).and("subCategoryName").is("")
                Criteria.where("downloadsCreated").gte(dateOne).andOperator(Criteria.where("downloadsCreated").lt(dateTwo))
        );}
    private Query filterById(String documentId) {
        return new Query(
                Criteria.where("_id").is(documentId)
        );
    }
}
