package com.sofka.docs;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.events.CategoryCreated;
import com.sofka.docs.events.DocumentCreated;
import com.sofka.docs.events.DocumentUpdated;
import com.sofka.docs.events.SubCategoryCreated;
import com.sofka.docs.values.BlockChainId;
import com.sofka.docs.values.CategoryId;
import com.sofka.docs.values.CategoryName;
import com.sofka.docs.values.Descriptiondoc;
import com.sofka.docs.values.DocName;
import com.sofka.docs.values.DocumentId;
import com.sofka.docs.values.PathDocument;
import com.sofka.docs.values.UserId;
import com.sofka.docs.values.VersionDocument;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Document extends AggregateEvent<DocumentId> {

    protected Map<DocumentId, UserId> downloads;

    protected DocName name;

    protected UserId userId;

    protected SubCategory subCategory;
    protected CategoryDoc category;

    protected LogHistory logHistory;
    protected Instant createdDate;

    protected VersionDocument version;
    protected PathDocument pathDocument;
    protected BlockChainId blockChainId;
    protected Descriptiondoc description;


    public Document(DocumentId entityId, LogHistory logHistory, VersionDocument version, PathDocument pathDocument,
                    BlockChainId blockChainId, Descriptiondoc description) {
        super(entityId);
        subscribe(new DocumentChange(this));
        appendChange(new DocumentCreated(category.identity(), logHistory.toString(), version.value(),
                pathDocument.value(), blockChainId.value())).apply();
    }

    /**
     * Instantiates a new Aggregate event.
     *
     * @param entityId the entity id
     */
    public Document(DocumentId entityId) {
        super(entityId);
        subscribe(new DocumentChange(this));
    }

    public static Document from(DocumentId id, List<DomainEvent> events) {
        Document document = new Document(id);
        events.forEach(document::applyEvent);
        return document;
    }

    public void createCategory(CategoryId categoryId, CategoryName categoryName) {
        Objects.requireNonNull(categoryId);
        Objects.requireNonNull(categoryName);
        appendChange(new CategoryCreated(categoryId.value(), categoryName.value())).apply();
    }

    public void createSubCategory(CategoryId categoryId, SubCategory subCategory) {
        Objects.requireNonNull(categoryId);
        Objects.requireNonNull(subCategory);
        appendChange(new SubCategoryCreated(categoryId.value(), subCategory)).apply();
    }

    public void updateDocument(DocName docName, UserId userId, CategoryId categoryId, LogHistory logHistory,
                               Instant createdDate, VersionDocument version,
                               PathDocument pathDocument, BlockChainId blockChainId, Descriptiondoc description) {
        Objects.requireNonNull(docName);
        Objects.requireNonNull(userId);
        Objects.requireNonNull(categoryId);
        Objects.requireNonNull(logHistory);
        Objects.requireNonNull(createdDate);
        Objects.requireNonNull(version);
        Objects.requireNonNull(description);
        Objects.requireNonNull(pathDocument);
        appendChange(new DocumentUpdated(docName.value(), userId.value(), categoryId.value(), logHistory.toString(),
                version.value(), pathDocument.value(), blockChainId.value(), description.value())).apply();
    }

    public void deleteDocument() {

    }
}
