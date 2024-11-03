package org.example.entity;

import jakarta.persistence.*;

import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "planet")
public class Planet {
    @Id
    @Pattern(regexp = "^[A-Z0-9]+$")
    private String id;

    @Column(nullable = false, length = 500)
    private String name;

    @OneToMany(mappedBy = "fromPlanet", fetch = FetchType.LAZY)
    private List<Ticket> ticketsFrom;

    @OneToMany(mappedBy = "toPlanet", fetch = FetchType.LAZY)
    private List<Ticket> ticketsTo;

    public List<Ticket> getTicketsFrom() {
        return ticketsFrom;
    }

    public void setTicketsFrom(List<Ticket> ticketsFrom) {
        this.ticketsFrom = ticketsFrom;
    }

    public List<Ticket> getTicketsTo() {
        return ticketsTo;
    }

    public void setTicketsTo(List<Ticket> ticketsTo) {
        this.ticketsTo = ticketsTo;
    }

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
