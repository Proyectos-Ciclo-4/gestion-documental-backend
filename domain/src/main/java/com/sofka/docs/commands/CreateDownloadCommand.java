package com.sofka.docs.commands;

import co.com.sofka.domain.generic.Command;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class CreateDownloadCommand extends Command {
    private String downloadId;
    private String documentId;
    private String userId;
    private final Instant downloadsCreated = Instant.now();

    public Instant getDownloadsCreated() {
        return downloadsCreated;
    }

    public String getDownloadId() {
        return downloadId;
    }

    public void setDownloadId(String downloadId) {
        this.downloadId = downloadId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
