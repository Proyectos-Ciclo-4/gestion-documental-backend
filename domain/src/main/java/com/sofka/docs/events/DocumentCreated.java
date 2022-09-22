package com.sofka.docs.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.CategoryDoc;
import com.sofka.docs.values.CategoryId;
import com.sofka.docs.values.Descriptiondoc;
import com.sofka.docs.values.DocName;
import com.sofka.docs.values.DocumentId;
import com.sofka.docs.values.LogHistoryId;
import com.sofka.docs.values.UserId;

import java.time.LocalDate;
import java.util.Map;

public class DocumentCreated extends DomainEvent {

    //private String userId;
  //  private Map<DocumentId, UserId> downloads;
    private LogHistoryId logHistoryId;
    private CategoryId categoryId;
    private CategoryDoc category;
    private String logHistory;
    private LocalDate createdDate;
    private Integer version;
    private String pathDocument;
    private String blockChainId;
    private Descriptiondoc description;
    private DocName docName;

    public DocName getDocName() {
        return docName;
    }

    public DocumentCreated(LogHistoryId logHistoryId){
        super("sofka.docs.documentcreated");
        this.logHistoryId=logHistoryId;
    }

    public DocumentCreated(String type, CategoryDoc category, String logHistory, LocalDate createdDate, Integer version, String pathDocument, String blockChainId, Descriptiondoc description, DocName docName) {
        super("sofka.docs.documentcreated");
        this.categoryId = categoryId;
        this.logHistory = logHistory;
        this.createdDate = createdDate;
        this.version = version;
        this.pathDocument = pathDocument;
        this.blockChainId = blockChainId;
        this.description = description;
        this.docName = docName;
    }

    public DocumentCreated(CategoryId categoryId, String logHistory,
                           LocalDate createdDate, Integer version, String pathDocument, String blockChainId){
        super("sofka.docs.documentcreated");
      //  this.userId= userId;
       // this.downloads = downloads;
        this.categoryId = categoryId;
        this.logHistory = logHistory;
        this.createdDate = createdDate;
        this.version = version;
        this.pathDocument = pathDocument;
        this.blockChainId = blockChainId;
    }

    public LogHistoryId getLogHistoryId() {
        return logHistoryId;
    }

    public CategoryDoc getCategory() {
        return category;
    }

    public Descriptiondoc getDescription() {
        return description;
    }

    public CategoryId getCategoryId() {
        return categoryId;
    }

    public String getLogHistory() {
        return logHistory;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public Integer getVersion() {
        return version;
    }

    public String getPathDocument() {
        return pathDocument;
    }

    public String getBlockChainId() {
        return blockChainId;
    }
}
