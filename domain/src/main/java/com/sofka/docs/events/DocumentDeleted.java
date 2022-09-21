package com.sofka.docs.events;

import co.com.sofka.domain.generic.DomainEvent;

import java.time.LocalDate;

public class DocumentDeleted extends DomainEvent {
    private String userId;
    private String categoryId;
    private String logHistory;
    private LocalDate createdDate;
    private Integer version;
    private String pathDocument;
    private String blockChainId;

    public DocumentDeleted(){
        super("sofka.docs.documentdeleted");
    }

    public DocumentDeleted(String userId, String categoryId, String logHistory,
                           LocalDate createdDate, Integer version, String pathDocument, String blockChainId){
        super("sofka.docs.documentdeleted");
        this.userId= userId;
        this.categoryId = categoryId;
        this.logHistory = logHistory;
        this.createdDate = createdDate;
        this.version = version;
        this.pathDocument = pathDocument;
        this.blockChainId = blockChainId;
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
}
