package com.torami.ToramiStore.infrastructure.dto.request.users;

import com.torami.ToramiStore.domain.models.users.enums.DocumentType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @NotNull(message = "Document type is required")
    private DocumentType documentType;

    @NotBlank(message = "Document number is required")
    @Size(min = 8, max = 12, message = "Document number must be between 8 and 12 characters")
    private String documentNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters")
    private String password;

    @NotBlank(message = "Department is required")
    private String departmentId;

    @NotBlank(message = "Province is required")
    private String provinceId;

    @NotBlank(message = "District is required")
    private String districtId;

    @NotBlank(message = "Address is required")
    @Size(max = 255, message = "Address cannot exceed 255 characters")
    private String address;

    @Size(max = 255, message = "Reference cannot exceed 255 characters")
    private String reference;
}
