package com.sofka.docdoc;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.docdoc.events.DownloadCreated;

public class DownLoadEventChange extends EventChange {
    public DownLoadEventChange(Download download) {
        apply((DownloadCreated event) -> {
            download.documentId = event.getDocumentId();
            download.userId = event.getUserId();
            download.downloadedDate = event.getDownloadsCreated();
        });
    }
}
