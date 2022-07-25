package kz.halykacademy.testappp;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public void createUser(CreateUserRequest userRequest) {
        repository.saveAndFlush(
                new User(
                        null,
                        userRequest.getLogin(),
                        userRequest.getPassword(),
                        userRequest.getRole()
                )
        );
    }
}
