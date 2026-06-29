package com.torami.ToramiStore.infrastructure.persistence.mapper.users;

import com.torami.ToramiStore.domain.models.users.Ubigeo;
import com.torami.ToramiStore.domain.models.users.User;
import com.torami.ToramiStore.infrastructure.persistence.entity.users.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toDomain(UserEntity entity) {
        if (entity == null) return null;

        Ubigeo ubigeo = new Ubigeo(
                null,
                entity.getDistrictId(),
                entity.getDepartmentId(),
                entity.getProvinceId(),
                entity.getDistrictId()
        );

        return new User(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getDocumentType(),
                entity.getDocumentNumber(),
                ubigeo,
                entity.getAddress(),
                entity.getReference(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getRole(),
                entity.isEnabled(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public UserEntity toEntity(User user) {
        if (user == null) return null;

        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setDocumentType(user.getDocumentType());
        entity.setDocumentNumber(user.getDocumentNumber());

        // Ubigeo
        if (user.getUbigeo() != null) {
            entity.setDepartmentId(user.getUbigeo().getDepartment());
            entity.setProvinceId(user.getUbigeo().getProvince());
            entity.setDistrictId(user.getUbigeo().getDistrict());
        }

        entity.setAddress(user.getAddress());
        entity.setReference(user.getReference());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setRole(user.getRole());
        entity.setEnabled(user.isEnabled());
        entity.setCreatedAt(user.getCreatedAt());
        entity.setUpdatedAt(user.getUpdatedAt());

        return entity;
    }
}
