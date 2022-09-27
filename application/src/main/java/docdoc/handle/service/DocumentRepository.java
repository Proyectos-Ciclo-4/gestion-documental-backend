package docdoc.handle.service;

import docdoc.handle.model.DocumentModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends ReactiveMongoRepository<DocumentModel, String> {/*Interface del repositorio*/}
