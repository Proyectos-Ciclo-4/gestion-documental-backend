package com.sofka.docdoc.values;

import co.com.sofka.domain.generic.Identity;

public class DocumentId extends Identity {

    public DocumentId(String uuid){
        super(uuid);
    }

    public DocumentId(){

    }

    public static DocumentId of(String uuid) {return new DocumentId(uuid);}
}
