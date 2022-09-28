package docdoc.handle.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;


public class DownloadModel {
    @Id
    protected String uuid;
    private String documentId;
    private String userId;
    private LocalDate downloadsCreated;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public LocalDate getDownloadsCreated() {
        return downloadsCreated;
    }

    public void setDownloadsCreated(LocalDate downloadsCreated) {
        this.downloadsCreated = downloadsCreated;
    }
}
