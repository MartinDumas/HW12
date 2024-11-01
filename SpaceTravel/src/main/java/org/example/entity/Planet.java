package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "planet")
public class Planet {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 500)
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
