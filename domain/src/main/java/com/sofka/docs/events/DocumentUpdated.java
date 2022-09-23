package com.sofka.docs.events;

import co.com.sofka.domain.generic.DomainEvent;

import java.time.Instant;
import java.time.LocalDate;

public class DocumentUpdated extends DomainEvent {
    private String documentName;
    private String userId;
    private String categoryId;
    private String logHistory;
    private Integer version;
    private String pathDocument;
    private String blockChainId;
    private String description;

    public DocumentUpdated() {
        super("sofka.docs.documentupdated");
    }

    public DocumentUpdated(String documentName, String userId, String categoryId, String logHistory,
                           Integer version, String pathDocument, String blockChainId,
                           String description) {
        super("sofka.docs.documentupdated");
        this.documentName = documentName;
        this.userId = userId;
        this.categoryId = categoryId;
        this.logHistory = logHistory;
        this.version = version;
        this.pathDocument = pathDocument;
        this.blockChainId = blockChainId;
        this.description = description;
    }

    public String getDocumentName() {
        return documentName;
    }

    public String getUserId() {
        return userId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getLogHistory() {
        return logHistory;
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

    public String getDescription() {
        return description;
    }

}
