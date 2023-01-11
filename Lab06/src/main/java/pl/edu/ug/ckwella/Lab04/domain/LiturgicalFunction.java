package pl.edu.ug.ckwella.Lab04.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LiturgicalFunction {
    private long id;
    private String name;
    private String description;

    public LiturgicalFunction(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public LiturgicalFunction() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "LiturgicalFunction{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }

}
