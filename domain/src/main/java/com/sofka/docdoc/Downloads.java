package com.sofka.docdoc;

import co.com.sofka.domain.generic.Entity;
import com.sofka.docdoc.values.DocumentId;
import com.sofka.docdoc.values.DownloadId;

public class Downloads extends Entity<DownloadId> {

    protected NumberDownloads numberDownloads;

    protected DocumentId documentId;

    public Downloads(DownloadId entityId, NumberDownloads numberDownloads, DocumentId documentId) {
        super(entityId);
        this.numberDownloads = numberDownloads;
        this.documentId = documentId;
    }

    public NumberDownloads getNumberDownloads() {
        return numberDownloads;
    }

    public DocumentId getDocumentId() {
        return documentId;
    }

    public void setNumberDownloads(NumberDownloads numberDownloads) {
        this.numberDownloads = numberDownloads;
    }

    public void setDocumentId(DocumentId documentId) {
        this.documentId = documentId;
    }
}
