package dev.syntax.boot.restapi.domain;

import javax.persistence.*;

@Entity
public class Coffee {
    @Id
    private String id;
    private String name;
    public Coffee() {
        super();
    }
    public Coffee(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Coffee [id=" + id + ", name=" + name + "]";
    }
}