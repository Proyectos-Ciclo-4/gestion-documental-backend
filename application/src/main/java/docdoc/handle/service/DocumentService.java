package docdoc.handle.service;

import docdoc.handle.model.DocumentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Mono<ResponseEntity<DocumentModel>> updateDocument(String id, DocumentModel docSend) {

        return documentRepository.findById(id).flatMap(docFind -> {

                    docFind.setUserId(IsNull.compareString(docSend.getUserId(), docFind.getUserId()));
                    docFind.setCategoryId(IsNull.compareString(docSend.getCategoryId(), docFind.getCategoryId()));
                    docFind.setVersion(docFind.getVersion() + 1);
                    docFind.setPathDocument(IsNull.compareString(docSend.getPathDocument(), docFind.getPathDocument()));

                    docFind.getBlockChainId().add(docSend.getBlockChainId().stream().findFirst().get());
                    docFind.setBlockChainId(docFind.getBlockChainId());

                    docFind.setDateUpload(Instant.now());
                    docFind.setLastDateDownload(IsNull.compareInstant(docSend.getLastDateDownload(), docFind.getLastDateDownload()));

                    docFind.setDescription(IsNull.compareString(docSend.getDescription(), docFind.getDescription()));
                    docFind.setName(IsNull.compareString(docSend.getName(), docFind.getName()));
                    docFind.setSubCategoryName(IsNull.compareString(docSend.getSubCategoryName(), docFind.getSubCategoryName()));
                    docFind.setUuid(docFind.getUuid());

                    return documentRepository.save(docFind);

                })
                .map(update -> ResponseEntity.ok().<DocumentModel>build())
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    public Mono<ResponseEntity<DocumentModel>> updateDownloadDocument(String id, DocumentModel docSend) {

        return documentRepository.findById(id).flatMap(docFind -> {
                    docFind.setLastDateDownload(IsNull.compareInstant(docSend.getLastDateDownload(), docFind.getLastDateDownload()));
                    return documentRepository.save(docFind);

                })
                .map(update -> ResponseEntity.ok().<DocumentModel>build())
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

}
