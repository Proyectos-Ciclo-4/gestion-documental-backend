package com.sofka.docs;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.events.DownloadCreated;
import com.sofka.docs.values.DocumentId;
import com.sofka.docs.values.DownloadId;
import com.sofka.docs.values.UserId;

import java.time.LocalDateTime;
import java.util.List;

public class Download extends AggregateEvent<DownloadId> {
    protected UserId userId;
    protected DocumentId documentId;
    protected LocalDateTime downloadedDate;
    protected Integer downloads;

    public Download(DownloadId entityId,UserId userId,DocumentId documentId,LocalDateTime downloadedDate) {
        super(entityId);
        subscribe(new DownLoadEventChange(this));
        appendChange(new DownloadCreated(documentId,userId,downloadedDate)).apply();
    }

    /**
     * Instantiates a new Aggregate event.
     *
     * @param entityId the entity id
     */
    public Download(DownloadId entityId) {
        super(entityId);
        subscribe(new DownLoadEventChange(this));
    }
    public static Download from(DownloadId id, List<DomainEvent> events) {
        var download = new Download(id);
        events.forEach(download::applyEvent);
        return download;
    }
}
