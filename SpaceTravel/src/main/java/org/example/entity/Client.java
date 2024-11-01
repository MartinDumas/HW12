package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false,length = 200)
    private String name;

    public Long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
