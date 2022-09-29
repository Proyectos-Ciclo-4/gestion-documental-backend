package docdoc.handle.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Set;

@Document(collection = "documents")
public class DocumentModel {

    protected String name;
    protected String userId;
    protected String subCategoryName;
    protected String categoryId;
    protected Integer version;
    protected String pathDocument;
    protected Set<String> blockChainId;
    protected String description;
    protected LocalDateTime dateCreated;
    protected LocalDateTime dateUpload;
    @Id
    protected String uuid;

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getPathDocument() {
        return pathDocument;
    }

    public void setPathDocument(String pathDocument) {
        this.pathDocument = pathDocument;
    }

    public Set<String> getBlockChainId() {
        return blockChainId;
    }

    public void setBlockChainId(Set<String> blockChainId) {
        this.blockChainId = blockChainId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateUpload() {
        return dateUpload;
    }

    public void setDateUpload(LocalDateTime dateUpload) {
        this.dateUpload = dateUpload;
    }
}
