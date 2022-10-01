package com.sofka.docdoc;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.docdoc.events.DocumentCreated;
import com.sofka.docdoc.values.*;

public class DocumentEventChange extends EventChange {

    public DocumentEventChange(Document document) {
        apply((DocumentCreated event) -> {
            document.description = event.getDescription();
            document.name = event.getDocName();
            document.pathDocument = event.getPathDocument();
            document.categoryId = event.getCategoryId();
            document.version = new VersionDocument(event.getVersion());
            document.blockChainId.addAll(event.getBlockChainId());
            document.subCategoryName = event.getSubcategoryName();
            document.dateCreated = event.getCreatedDate();
            document.dateUpdated = event.getCreatedDate();
            document.lastDateDownloaded = event.getLastDateDownloaded();
        });
    }
}
