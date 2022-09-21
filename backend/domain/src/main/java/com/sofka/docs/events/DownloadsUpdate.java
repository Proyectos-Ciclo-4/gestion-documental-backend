package com.sofka.docs.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.NumberDownloads;
import com.sofka.docs.values.DocumentId;
import com.sofka.docs.values.DownloadId;
import com.sofka.docs.values.UserId;

import java.util.UUID;

public class DownloadsUpdate extends DomainEvent {

    private DownloadId downloadId;

    private DocumentId documentId;

    private UserId userId;

    private NumberDownloads numberDownloads;

    public DownloadsUpdate() {
        super("sofka.docs.downloadsupdate");
    }

    public DownloadsUpdate(DownloadId downloadId, DocumentId documentId, UserId userId, NumberDownloads numberDownloads) {
        super("sofka.docs.downloadsupdate");
        this.downloadId = downloadId;
        this.documentId = documentId;
        this.userId = userId;
        this.numberDownloads = numberDownloads;
    }

    public DownloadId getDownloadId() {
        return downloadId;
    }

    public DocumentId getDocumentId() {
        return documentId;
    }

    public UserId getUserId() {
        return userId;
    }

    public NumberDownloads getNumberDownloads() {
        return numberDownloads;
    }
}
