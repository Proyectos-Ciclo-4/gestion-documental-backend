package com.sofka.docs.commands;

import co.com.sofka.domain.generic.Command;

public class DownloadsUpdateCommand extends Command {

    private String DownloadId;

    private String DocumentId;

    private String UserId;

    private Integer numberDownloads;


    public void setUserId(String userId) {
        this.UserId = userId;
    }

    public void setDownloadId(String downloadId) {
        this.DownloadId = downloadId;
    }

    public void setDocumentId(String documentId) {
        this.DocumentId = documentId;
    }

    public void setNumberDownloads(Integer numberDownloads) {
        this.numberDownloads = numberDownloads;
    }

    public String getUserId() {
        return UserId;
    }

    public String getDownloadId() {
        return DownloadId;
    }

    public String getDocumentId() {
        return DocumentId;
    }

    public Integer getNumberDownloads() {
        return numberDownloads;
    }
}
