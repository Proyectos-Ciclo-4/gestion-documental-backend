package com.sofka.docs.commands;

import co.com.sofka.domain.generic.Command;

import java.time.LocalDateTime;

public class CreateDownloadCommand extends Command {
    private String downloadId;
    private String documentId;
    private String userId;

    private LocalDateTime downloadsCreated;

    public LocalDateTime getDownloadsCreated() {
        return downloadsCreated;
    }

    public void setDownloadsCreated(LocalDateTime downloadsCreated) {
        this.downloadsCreated = downloadsCreated;
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
