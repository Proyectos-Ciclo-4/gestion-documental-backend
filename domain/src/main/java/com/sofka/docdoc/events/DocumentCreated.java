package com.sofka.docdoc.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docdoc.values.CategoryId;
import com.sofka.docdoc.values.Descriptiondoc;
import com.sofka.docdoc.values.DocName;
import com.sofka.docdoc.values.PathDocument;
import com.sofka.docdoc.values.SubcategoryName;

import java.time.Instant;
import java.util.Set;

public class DocumentCreated extends DomainEvent {
        private CategoryId categoryId;
    private Integer version;
    private SubcategoryName subcategoryName;
    private PathDocument pathDocument;
    private Set<String> blockChainId;
    private Descriptiondoc description;
    private DocName docName;

    private Instant dateCreated;

    private Instant dateUpdated;

    private Instant lastDateDownloaded;

    public DocName getDocName() {
        return docName;
    }

    public DocumentCreated(CategoryId categoryId, Integer version, PathDocument pathDocument, Set<String> blockChainId,
                           Descriptiondoc description, DocName docName, SubcategoryName subcategoryName, Instant dateCreated,
                           Instant dateUpdated, Instant lastDateDownloaded) {
        super("sofka.docs.documentcreated");
        this.categoryId = categoryId;
        this.version = version;
        this.pathDocument = pathDocument;
        this.blockChainId = blockChainId;
        this.description = description;
        this.docName = docName;
        this.subcategoryName = subcategoryName;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.lastDateDownloaded = lastDateDownloaded;
    }

    public Instant getLastDateDownloaded() {
        return lastDateDownloaded;
    }

    public Descriptiondoc getDescription() {
        return description;
    }

    public CategoryId getCategoryId() {
        return categoryId;
    }

    public Integer getVersion() {
        return version;
    }

    public PathDocument getPathDocument() {
        return pathDocument;
    }

    public Set<String> getBlockChainId() {
        return blockChainId;
    }

    public SubcategoryName getSubcategoryName() {
        return subcategoryName;
    }

    public Instant getCreatedDate() {
        return dateCreated;
    }

    public Instant getDateUpdated() {
        return dateUpdated;
    }

    @Override
    public String toString() {
        return "DocumentCreated{" +
                "categoryId=" + categoryId +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                ", version=" + version +
                ", subcategoryName=" + subcategoryName +
                ", pathDocument=" + pathDocument +
                ", blockChainId=" + blockChainId +
                ", description=" + description +
                ", docName=" + docName +
                '}';
    }
}
