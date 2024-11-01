package org.example.entity;

import jakarta.persistence.*;

import javax.validation.constraints.Pattern;


@Entity
@Table(name = "planet")
public class Planet {
    @Id
    @Pattern(regexp = "^[A-Z0-9]+$")
    private String id;

    @Column(nullable = false, length = 500)
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
