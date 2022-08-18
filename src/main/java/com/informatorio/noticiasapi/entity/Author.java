package com.informatorio.noticiasapi.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private String fullname;

    @CreationTimestamp
    private LocalDateTime createdAt;

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
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}