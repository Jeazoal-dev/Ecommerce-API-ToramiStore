package com.torami.ToramiStore.infrastructure.persistence.adapter.users;

import com.torami.ToramiStore.application.port.out.users.IUserRepository;
import com.torami.ToramiStore.domain.models.users.User;
import com.torami.ToramiStore.infrastructure.persistence.entity.users.UserEntity;
import com.torami.ToramiStore.infrastructure.persistence.mapper.users.UserMapper;
import com.torami.ToramiStore.infrastructure.persistence.repository.users.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserJpaAdapter implements IUserRepository {

    private final UserJpaRepository jpaRepository;
    private final UserMapper mapper;

    @Override
    public User save(User user) {
        UserEntity entity = mapper.toEntity(user);
        UserEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepository.findByEmail(email).map(mapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }
}