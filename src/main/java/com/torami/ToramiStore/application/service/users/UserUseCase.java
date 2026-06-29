package com.torami.ToramiStore.application.service.users;

import com.torami.ToramiStore.application.port.in.users.IUserService;
import com.torami.ToramiStore.application.port.out.users.IUserRepository;
import com.torami.ToramiStore.domain.exceptions.users.UserAlreadyExistsException;
import com.torami.ToramiStore.domain.exceptions.users.UserNotFoundException;
import com.torami.ToramiStore.domain.models.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserUseCase implements IUserService {

    private final IUserRepository repository;
    private final PasswordEncoder encoder;

    @Override
    @Transactional
    public User register(User user) {

        if (repository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExistsException(user.getEmail());
        }

        String encodedPassword = encoder.encode(user.getPassword());

        User encryptedUser = new User(
                user.getFirstName(),
                user.getLastName(),
                user.getDocumentType(),
                user.getDocumentNumber(),
                user.getUbigeo(),
                user.getAddress(),
                user.getReference(),
                user.getEmail(),
                encodedPassword,
                user.getRole()
        );

        return repository.save(encryptedUser);
    }

    @Override
    public User getByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(email));
    }

    @Override
    public User getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}