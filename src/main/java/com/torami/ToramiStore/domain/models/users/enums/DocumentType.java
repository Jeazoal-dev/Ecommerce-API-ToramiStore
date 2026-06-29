package com.torami.ToramiStore.domain.models.users.enums;

public enum DocumentType {
    DNI("DNI"),
    CE("Carnet de Extranjería"),
    PASAPORTE("Pasaporte");

    private final String displayName;

    DocumentType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}