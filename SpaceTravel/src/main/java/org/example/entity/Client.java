package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false,length = 200)
    private String name;

    public long getId() {
        return id;
    }



    public String getName() {
        return name;
    }


}
