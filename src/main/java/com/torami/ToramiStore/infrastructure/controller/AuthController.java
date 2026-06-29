package com.torami.ToramiStore.infrastructure.controller;

import com.torami.ToramiStore.application.port.in.users.IUserService;
import com.torami.ToramiStore.domain.models.users.Ubigeo;
import com.torami.ToramiStore.domain.models.users.User;
import com.torami.ToramiStore.infrastructure.dto.request.users.RegisterRequest;
import com.torami.ToramiStore.infrastructure.dto.response.ApiResponse;
import com.torami.ToramiStore.infrastructure.dto.response.users.UserResponse;
import com.torami.ToramiStore.infrastructure.persistence.mapper.users.UserResponseMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IUserService userService;
    private final UserResponseMapper responseMapper;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>> register(
            @Valid @RequestBody RegisterRequest request,
            HttpServletRequest httpRequest) {

        Ubigeo ubigeo = new Ubigeo(
                null,
                request.getDistrictId(),
                request.getDepartmentId(),
                request.getProvinceId(),
                request.getDistrictId()
        );

        User user = new User(
                request.getFirstName(),
                request.getLastName(),
                request.getDocumentType(),
                request.getDocumentNumber(),
                ubigeo,
                request.getAddress(),
                request.getReference(),
                request.getEmail(),
                request.getPassword(),
                com.torami.ToramiStore.domain.models.users.enums.Role.USER
        );

        User saved = userService.register(user);
        UserResponse data = responseMapper.toResponse(saved);

        ApiResponse<UserResponse> apiResponse = ApiResponse.created(
                data,
                "User registered successfully",
                httpRequest.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }
}
