package com.sofka.docdoc;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docdoc.events.CategoryCreated;
import com.sofka.docdoc.events.DocumentCreated;
import com.sofka.docdoc.values.CategoryId;
import com.sofka.docdoc.values.CategoryName;
import com.sofka.docdoc.values.Descriptiondoc;
import com.sofka.docdoc.values.DocName;
import com.sofka.docdoc.values.DocumentId;
import com.sofka.docdoc.values.PathDocument;
import com.sofka.docdoc.values.SubcategoryName;
import com.sofka.docdoc.values.UserId;
import com.sofka.docdoc.values.VersionDocument;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Document extends AggregateEvent<DocumentId> {

    protected DocName name;

    protected UserId userId;
    protected SubcategoryName subCategoryName;

    protected CategoryId categoryId;

    protected LogHistory logHistory;

    protected VersionDocument version;
    protected PathDocument pathDocument;

    protected Set<String> blockChainId;
    protected Descriptiondoc description;

    protected Instant dateCreated;

    protected Instant dateUpdated;

    protected Instant lastDateDownloaded;

    public Document(DocumentId entityId,
                    DocName name,
                    CategoryId categoryId,
                    VersionDocument version,
                    PathDocument pathDocument,
                    Set<String> blockChainId,
                    Descriptiondoc description,
                    SubcategoryName subCategoryName,
                    Instant dateCreated,
                    Instant dateUpdated,
                    Instant lastDateDownloaded) {
        super(entityId);
        subscribe(new DocumentEventChange(this));
        appendChange(new DocumentCreated(categoryId, version.value(), pathDocument, blockChainId, description,
                name, subCategoryName, dateCreated, dateUpdated, lastDateDownloaded)).apply();

    }

    public Document(DocumentId entityId) {
        super(entityId);
        subscribe(new DocumentEventChange(this));
    }

    public static Document from(DocumentId id, List<DomainEvent> events) {
        var document = new Document(id);
        events.forEach(document::applyEvent);
        return document;
    }


    public void createCategory(CategoryName categoryName) {
        var categoryId = new CategoryId();
        Objects.requireNonNull(categoryName);
        appendChange(new CategoryCreated()).apply();
    }

}
