package com.informatorio.noticiasapi.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import javax.validation.constraints.NotEmpty;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre no puede estar vacio.")
    private String firstName;

    @NotEmpty(message = "El apellido no puede estar vacio.")
    private String lastName;

    @NotEmpty(message = "El nombre completo no puede estar vacio.")
    private String fullName;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Article> articles = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullname() {
        return fullName;
    }

    public void setFullname(String fullName) {
        this.fullName = fullName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}