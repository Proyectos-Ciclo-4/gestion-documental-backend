package com.sofka.docdoc.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docdoc.values.DocumentId;
import com.sofka.docdoc.values.UserId;

import java.time.Instant;

public class DownloadCreated extends DomainEvent {

    private DocumentId documentId;
    private UserId userId;
    private Instant downloadsCreated;

    public DownloadCreated() {
        super("sofka.docs.downloadcreated");
    }

    public DownloadCreated(DocumentId documentId, UserId userId, Instant downloadsCreated) {
        super("sofka.docs.downloadcreated");
        this.documentId = documentId;
        this.userId = userId;
        this.downloadsCreated = downloadsCreated;
    }

    public DocumentId getDocumentId() {
        return documentId;
    }

    public void setDocumentId(DocumentId documentId) {
        this.documentId = documentId;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public Instant getDownloadsCreated() {
        return downloadsCreated;
    }

    public void setDownloadsCreated(Instant downloadsCreated) {
        this.downloadsCreated = downloadsCreated;
    }
}
