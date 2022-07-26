package kz.halykacademy.testappp;

import org.springframework.data.annotation.Version;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/authors")
public class AuthorController {
    private static LinkedList<AuthorDTO> AUTHORS = new LinkedList(List.of(new AuthorDTO(1L, "Author", LocalDateTime.now())));

    @GetMapping
    public Page<AuthorDTO> getAuthors(
            Pageable pageRequest
    ) {
        return new PageImpl(
                AUTHORS.stream().skip(pageRequest.getOffset()).limit(pageRequest.getPageSize()).collect(Collectors.toList())
        );
    }

    @PostMapping
    public AuthorDTO saveAuthor(@RequestBody AuthorRequest authorToSave) {
        AuthorDTO newAuthor = new AuthorDTO(
                AUTHORS.getLast().getId() + 1,
                authorToSave.getFirstName(),
                LocalDateTime.now()
        );

        AUTHORS.add(
                newAuthor
        );

        return newAuthor;
    }

    @PostMapping("/{id}")
    public void update(
            @RequestBody AuthorRequest authorRequest,
            @PathVariable Long id
    ) {
        AuthorDTO foundAuthor = AUTHORS.stream()
                .filter(authorDTO -> authorDTO.getId().equals(id)).findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Author not found"));

        foundAuthor.setFirstName(authorRequest.getFirstName());
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {
        AUTHORS = new LinkedList(AUTHORS.stream()
                .filter(authorDTO -> !authorDTO.getId().equals(id)).findFirst()
                .stream().collect(Collectors.toList()));

    }
}

class AuthorRequest {
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}

class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
