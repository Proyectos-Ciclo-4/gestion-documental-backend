package com.sofka.docs;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.docs.events.CategoryCreated;
import com.sofka.docs.events.DocumentCreated;
import com.sofka.docs.events.SubCategoryCreated;
import com.sofka.docs.values.*;

import java.time.Instant;

public class DocumentChange extends EventChange {

    public DocumentChange(Document document) {
        apply((DocumentCreated event) -> {
            document.description = event.getDescription();
            document.name = event.getDocName();
            document.pathDocument = new PathDocument(event.getPathDocument());
            document.category = new CategoryDoc(
                    UserId.of("user"),
                    event.getCategory().identity(),
                    event.getCategory().categoryName);
            document.createdDate = Instant.now();
            document.version = new VersionDocument(event.getVersion());
            document.blockChainId = new BlockChainId(event.getBlockChainId());
        });
//        apply((CategoryCreated event) -> {
//            document.category = new CategoryDoc(new CategoryId(event.getId()), new CategoryName(event.getCategoryName()));
//        });
    }
}
