package kz.halykacademy.testappp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AuthorRepoTest {
    @Autowired
    private AuthorRepository repository;

    @Test
    public void createAtAutoSet() {
        Author author = new Author();
        author.setFirstName("First name");
        Author savedAuthor = repository.saveAndFlush(author);
        Assertions.assertNotNull(savedAuthor.getCreatedAt());
        Assertions.assertNotNull(savedAuthor.getId());
    }
}
