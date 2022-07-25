package kz.halykacademy.testappp;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    @PostConstruct
    public void init() {
        Optional<User> admin = repository.findByLogin("admin");
        if (admin.isEmpty()) {
            repository.saveAndFlush(
                    new User(
                            null,
                            "admin",
                            encoder.encode("user"),
                            "ADMIN"
                    )
            );
        }
    }

    public void createUser(CreateUserRequest userRequest) {
        repository.saveAndFlush(
                new User(
                        null,
                        userRequest.getLogin(),
                        encoder.encode(userRequest.getPassword()),
                        userRequest.getRole()
                )
        );
    }
}
