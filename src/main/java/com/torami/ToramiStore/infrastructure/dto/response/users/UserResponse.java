package com.torami.ToramiStore.infrastructure.dto.response.users;

import com.torami.ToramiStore.domain.models.users.enums.DocumentType;
import com.torami.ToramiStore.domain.models.users.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private DocumentType documentType;
    private String documentNumber;
    private UbigeoResponse ubigeo;
    private String address;
    private String reference;
    private String email;
    private Role role;
    private LocalDateTime createdAt;
}
