package com.sofka.docs;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.docs.events.DocumentCreated;
import com.sofka.docs.values.*;

public class DocumentEventChange extends EventChange {

    public DocumentEventChange(Document document) {
        apply((DocumentCreated event) -> {
            document.description = event.getDescription();
            document.name = event.getDocName();
            document.pathDocument = event.getPathDocument();
            document.categoryId = event.getCategoryId();
            document.version = new VersionDocument(event.getVersion());
            document.blockChainId = event.getBlockChainId();
            document.subCategoryName = event.getSubcategoryName();
            document.dateCreated= event.getCreatedDate();
        });
    }
}
