package com.sofka.docs;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.docs.events.CategoryCreated;
import com.sofka.docs.events.DocumentCreated;
import com.sofka.docs.events.DocumentUpdated;
import com.sofka.docs.events.LogHistoryAdded;
import com.sofka.docs.events.SubCategoryCreated;
import com.sofka.docs.values.BlockChainId;
import com.sofka.docs.values.CategoryId;
import com.sofka.docs.values.CategoryName;
import com.sofka.docs.values.CreatedDate;
import com.sofka.docs.values.Descriptiondoc;
import com.sofka.docs.values.DocName;
import com.sofka.docs.values.DocumentId;
import com.sofka.docs.values.LogHistoryId;
import com.sofka.docs.values.PathDocument;
import com.sofka.docs.values.SubcategoryId;
import com.sofka.docs.values.SubcategoryName;
import com.sofka.docs.values.UserId;
import com.sofka.docs.values.VersionDocument;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Document extends AggregateEvent<DocumentId> {
    protected Map<DocumentId, UserId> downloads;
    protected DocName name;
    protected SubCategory subCategory;
    protected CategoryDoc category;

    protected Set<LogHistory> logsHistory;
    protected CreatedDate createdDate;

    protected VersionDocument version;
    protected PathDocument pathDocument;
    protected BlockChainId blockChainId;
    protected Descriptiondoc description;

    public Document(DocumentId entityId, DocName name, CategoryId categoryId, VersionDocument version, PathDocument pathDocument, BlockChainId blockChainId, Descriptiondoc description) {
        super(entityId);
        subscribe(new DocumentEventChange(this));
        appendChange(new DocumentCreated(categoryId,version.value(), pathDocument, blockChainId, description,name)).apply();

    }

/*public Document(DocumentId entityId,
                    LogHistoryId logHistoryId,
                    LogHistoryFactory logHistoryFactory) {
        super(entityId);
        appendChange(new DocumentCreated(logHistoryId)).apply();
        logHistoryFactory.getLogsHistory().forEach(logHistory -> {
            appendChange( new LogHistoryAdded(logHistory.identity()));
        });
        subscribe(new DocumentEventChange(this));
    }*/

    /**
     * Instantiates a new Aggregate event.
     *
     * @param entityId the entity id
     */
    public Document(DocumentId entityId) {
        super(entityId);
        subscribe(new DocumentEventChange(this));
    }

    public static Document from(DocumentId id, List<DomainEvent> events){
        var document = new Document(id);
        events.forEach(document::applyEvent);
        return document;
    }

    public void createCategory(CategoryName categoryName){
        var categoryId = new CategoryId();
        Objects.requireNonNull(categoryName);
        appendChange(new CategoryCreated(categoryId, categoryName)).apply();
    }

    public void createSubCategory(CategoryId categoryId, SubcategoryName subCategoryName){
        Objects.requireNonNull(categoryId);
        var subCategoryId= new SubcategoryId();
        Objects.requireNonNull(subCategoryName);
        appendChange(new SubCategoryCreated(categoryId, subCategoryId,subCategoryName)).apply();
    }



    public void updateDocument(DocName docName, UserId userId, CategoryId categoryId, LogHistory logHistory,
                               CreatedDate createdDate, VersionDocument version,
                               PathDocument pathDocument,BlockChainId blockChainId, Descriptiondoc description){
        Objects.requireNonNull(docName);
        Objects.requireNonNull(userId);
        Objects.requireNonNull(categoryId);
        Objects.requireNonNull(logHistory);
        Objects.requireNonNull(createdDate);
        Objects.requireNonNull(version);
        Objects.requireNonNull(description);
        Objects.requireNonNull(pathDocument);
        appendChange(new DocumentUpdated(docName.value(),userId.value(), categoryId.value(),logHistory.toString(),
                createdDate.value() ,version.value(), pathDocument.value(),blockChainId.value(), description.value())).apply();
    }

    public void deleteDocument()
    {

    }
}
