package com.torami.ToramiStore.infrastructure.persistence.mapper.users;

import com.torami.ToramiStore.domain.models.users.User;
import com.torami.ToramiStore.infrastructure.dto.response.users.UbigeoResponse;
import com.torami.ToramiStore.infrastructure.dto.response.users.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserResponseMapper {

    private final UbigeoMapper ubigeoMapper;

    public UserResponse toResponse(User user) {
        if (user == null) return null;

        UbigeoResponse ubigeo = ubigeoMapper.toResponse(user.getUbigeo());

        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getDocumentType(),
                user.getDocumentNumber(),
                ubigeo,
                user.getAddress(),
                user.getReference(),
                user.getEmail(),
                user.getRole(),
                user.getCreatedAt()
        );
    }
}