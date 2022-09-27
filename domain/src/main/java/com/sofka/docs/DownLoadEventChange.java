package com.sofka.docs;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.docs.events.DownloadCreated;

import java.time.Instant;

public class DownLoadEventChange extends EventChange {
    public DownLoadEventChange(Download download) {
        apply((DownloadCreated event) -> {
            download.documentId = event.getDocumentId();
            download.userId = event.getUserId();
            download.downloadedDate = event.getDownloadsCreated();
        });
    }
}
