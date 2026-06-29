package com.torami.ToramiStore.domain.models.users;

import com.torami.ToramiStore.domain.models.users.enums.DocumentType;
import com.torami.ToramiStore.domain.models.users.enums.Role;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class User {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final DocumentType documentType;
    private final String documentNumber;
    private final Ubigeo ubigeo;
    private final String address;
    private final String reference;
    private final String email;
    private final String password;
    private final Role role;
    private final boolean enabled;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public User(Integer id, String firstName, String lastName, DocumentType documentType,
                String documentNumber, Ubigeo ubigeo, String address, String reference,
                String email, String password, Role role, boolean enabled,
                LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.ubigeo = ubigeo;
        this.address = address;
        this.reference = reference;
        this.email = email;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User(String firstName, String lastName, DocumentType documentType,
                String documentNumber, Ubigeo ubigeo, String address, String reference,
                String email, String password, Role role) {
        this(null, firstName, lastName, documentType, documentNumber, ubigeo,
                address, reference, email, password, role, true,
                LocalDateTime.now(), LocalDateTime.now());
    }

    public User(String firstName, String lastName, DocumentType documentType,
                String documentNumber, Ubigeo ubigeo, String address, String reference,
                String email, String password) {
        this(firstName, lastName, documentType, documentNumber, ubigeo,
                address, reference, email, password, Role.USER);
    }
}
