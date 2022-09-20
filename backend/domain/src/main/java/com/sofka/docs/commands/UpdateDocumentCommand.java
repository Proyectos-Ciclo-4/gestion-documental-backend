package com.sofka.docs.commands;

import java.time.LocalDate;

public class UpdateDocumentCommand {
    private String documentName;
    private String documentId;
    private String userId;
    private String categoryId;
    private String logHistory;
    private LocalDate createdDate;
    private Integer version;
    private String pathDocument;
    private String blockChainId;
    private String description;

    public UpdateDocumentCommand(String documentName ,String documentId, String userId, String categoryId, String logHistory,
                                 LocalDate createdDate, Integer version, String pathDocument,
                                 String blockChainId, String description) {
        this.documentName = documentName;
        this.documentId = documentId;
        this.userId = userId;
        this.categoryId = categoryId;
        this.logHistory = logHistory;
        this.createdDate = createdDate;
        this.version = version;
        this.pathDocument = pathDocument;
        this.blockChainId = blockChainId;
        this.description = description;
    }

    public String getDocumentName() {
        return documentName;
    }

    public String getDocumentId() {
        return documentId;
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
    public String getDescription() {
        return description;
    }
}
