package kz.halykacademy.testappp;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public class AuthorDTO {
    private Long id;
    private String firstName;
    private LocalDateTime createdAt;

    public AuthorDTO(Long id, String firstName, LocalDateTime createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
