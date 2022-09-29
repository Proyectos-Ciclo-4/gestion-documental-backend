package com.sofka.docs.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.CategoryDoc;
import com.sofka.docs.values.BlockChainId;
import com.sofka.docs.values.CategoryId;
import com.sofka.docs.values.Descriptiondoc;
import com.sofka.docs.values.DocName;
import com.sofka.docs.values.DocumentId;
import com.sofka.docs.values.LogHistoryId;
import com.sofka.docs.values.PathDocument;
import com.sofka.docs.values.SubcategoryName;
import com.sofka.docs.values.UserId;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

public class DocumentCreated extends DomainEvent {

    private String _id;

    private CategoryId categoryId;

    private Instant dateCreated;

    private Instant dateUpdated;
    private Integer version;
    private SubcategoryName subcategoryName;
    private PathDocument pathDocument;
    private Set<String> blockChainId;
    private Descriptiondoc description;
    private DocName docName;

    public DocName getDocName() {
        return docName;
    }

    public DocumentCreated(CategoryId categoryId, Integer version, PathDocument pathDocument, Set<String> blockChainId,
                           Descriptiondoc description, DocName docName, SubcategoryName subcategoryName, Instant dateCreated, Instant dateUpdated) {
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

    public String get_id() {
        return _id;
    }
}
