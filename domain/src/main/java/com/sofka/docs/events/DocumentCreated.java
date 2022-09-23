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

import java.time.LocalDate;
import java.util.Map;

public class DocumentCreated extends DomainEvent {

    //private String userId;
  //  private Map<DocumentId, UserId> downloads;
    private LogHistoryId logHistoryId;
    private CategoryId categoryId;
    private CategoryDoc category;
    private String logHistory;
    private LocalDate createdDate;
    private Integer version;
    private SubcategoryName subcategoryName;

    private PathDocument pathDocument;
    private BlockChainId blockChainId;
    private Descriptiondoc description;
    private DocName docName;

    public DocName getDocName() {
        return docName;
    }

    public DocumentCreated( CategoryId categoryId, Integer version, PathDocument pathDocument, BlockChainId blockChainId, Descriptiondoc description, DocName docName,SubcategoryName subcategoryName) {
        super("sofka.docs.documentcreated");
        this.categoryId = categoryId;
        this.version = version;
        this.pathDocument = pathDocument;
        this.blockChainId = blockChainId;
        this.description = description;
        this.docName = docName;
        this.subcategoryName = subcategoryName;
    }

    public LogHistoryId getLogHistoryId() {
        return logHistoryId;
    }

    public CategoryDoc getCategory() {
        return category;
    }

    public Descriptiondoc getDescription() {
        return description;
    }

    public CategoryId getCategoryId() {
        return categoryId;
    }

    public String getLogHistory() {
        return logHistory;
    }

    public Integer getVersion() {
        return version;
    }

    public PathDocument getPathDocument() {
        return pathDocument;
    }

    public BlockChainId getBlockChainId() {
        return blockChainId;
    }

    public SubcategoryName getSubcategoryName() {
        return subcategoryName;
    }
}
