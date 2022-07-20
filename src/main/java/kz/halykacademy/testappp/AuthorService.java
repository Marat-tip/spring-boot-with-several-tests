package kz.halykacademy.testappp;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AuthorService {
    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        Author author = new Author();
        author.setFirstName("Author");
        repository.saveAndFlush(
                author
        );
    }
}
