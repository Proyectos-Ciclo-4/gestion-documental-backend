package docdoc.handle.service;

import docdoc.handle.model.DocumentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DocumentService {

    // Enlace del repositorio
    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    // Servicio de update
    public Mono<ResponseEntity<DocumentModel>> updateDocument(String id, DocumentModel docSend){

        return documentRepository.findById(id).flatMap(docFind ->{

            docFind.setName(docSend.getName());
            docFind.setSubCategoryName(docSend.getSubCategoryName());
            docFind.setCategoryId(docSend.getCategoryId());
            docFind.setVersion(docSend.getVersion());
            docFind.setPathDocument(docSend.getPathDocument());
            docFind.setBlockChainId(docSend.getBlockChainId());
            docFind.setDescription(docSend.getDescription());

            return documentRepository.save(docFind);

        })
        .map(update -> ResponseEntity.ok().<DocumentModel>build())
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

}
