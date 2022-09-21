package com.sofka.docs;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.Entity;
import com.sofka.docs.values.DocumentId;

public class Downloads extends Entity<DownloadId> {

    protected NumberDownloads numberDownloads;

    protected DocumentId documentId;

    public Downloads(DownloadId downloadId, NumberDownloads numberDownloads, DocumentId documentId){
        super(DownloadId);
        subscribe(new DownloadChange(this));
        appendChange()
    }

}
