package com.sofka.docs.events;

import co.com.sofka.domain.generic.DomainEvent;

import java.time.LocalDate;

public class DocumentUpdated extends DomainEvent {
    private String documentName;
    private String userId;
    private String categoryId;
    private String logHistory;
    private LocalDate createdDate;
    private Integer version;
    private String pathDocument;
    private String blockChainId;
    private String description;

    public DocumentUpdated(){
        super("sofka.docs.documentupdated");
    }

    public DocumentUpdated(String documentName ,String userId, String categoryId, String logHistory,
                           LocalDate createdDate, Integer version, String pathDocument, String blockChainId,
                           String decription){
        super("sofka.docs.documentupdated");
        this.documentName = documentName;
        this.userId= userId;
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
/*  public DocumentUpdated( String documentName, LocalDate createdDate, Integer version, String pathDocument,
                            String blockChainId){
        super("sofka.docs.documentupdated");
        this.documentName = documentName;
        this.createdDate = createdDate;
        this.version = version;
        this.pathDocument = pathDocument;
        this.blockChainId = blockChainId;
    }*/


}
