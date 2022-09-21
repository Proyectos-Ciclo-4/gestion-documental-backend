package com.sofka.docs;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.docs.events.CategoryCreated;
import com.sofka.docs.events.DocumentCreated;
import com.sofka.docs.values.BlockChainId;
import com.sofka.docs.values.CategoryId;
import com.sofka.docs.values.CategoryName;
import com.sofka.docs.values.CreatedDate;
import com.sofka.docs.values.PathDocument;
import com.sofka.docs.values.VersionDocument;

public class DocumentChange extends EventChange {

    public DocumentChange(Document document) {
        apply((DocumentCreated event) -> {
            document.description=event.getDescription();
            document.name=event.getDocName();
            document.pathDocument= new PathDocument(event.getPathDocument());
            document.category=new CategoryDoc(event.getCategory().identity(),event.getCategory().categoryName());
            document.createdDate=new CreatedDate(event.getCreatedDate());
            document.version=new VersionDocument(event.getVersion());
            document.blockChainId=new BlockChainId(event.getBlockChainId());
        });
        apply((CategoryCreated event) -> {
            document.category= new CategoryDoc(new CategoryId(event.getId()),new CategoryName(event.getCategoryName()));
        });


    }
}
