package com.minhnb.spring.restapi.base;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Type(type = "pg-uuid")
    protected UUID id = UUID.randomUUID();

    @Column(name = "created_date", nullable = false)
    protected LocalDateTime createdDate = LocalDateTime.now();

    @Column(name = "updated_date", nullable = false)
    protected LocalDateTime updatedDate = LocalDateTime.now();

    @PrePersist
    private void prePersist() {
        createdDate = LocalDateTime.now();
        updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate() {
        updatedDate = LocalDateTime.now();
    }

    public BaseEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

}
