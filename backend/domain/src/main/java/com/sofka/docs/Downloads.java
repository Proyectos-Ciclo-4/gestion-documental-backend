package com.sofka.docs;

import co.com.sofka.domain.generic.Entity;
import com.sofka.docs.values.DocumentId;
import com.sofka.docs.values.DownloadId;

public class Downloads extends Entity<DownloadId> {

    protected NumberDownloads numberDownloads;

    protected DocumentId documentId;

    public Downloads(DownloadId entityId, NumberDownloads numberDownloads, DocumentId documentId) {
        super(entityId);
        this.numberDownloads = numberDownloads;
        this.documentId = documentId;
    }
}
