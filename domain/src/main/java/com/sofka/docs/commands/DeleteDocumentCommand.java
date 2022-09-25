package com.sofka.docs.commands;

import co.com.sofka.domain.generic.Command;

import java.time.LocalDate;

public class DeleteDocumentCommand extends Command {
    private String documentId;
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
    public String getDocumentId() {
        return documentId;
    }
}
