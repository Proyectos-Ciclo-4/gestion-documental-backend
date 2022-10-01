package com.sofka.docdoc.commands;

import co.com.sofka.domain.generic.Command;

import java.time.Instant;

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
