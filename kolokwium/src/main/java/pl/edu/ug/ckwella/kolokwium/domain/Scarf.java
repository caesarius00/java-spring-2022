package pl.edu.ug.ckwella.kolokwium.domain;

import javax.persistence.*;

@Entity

public class Scarf {
    @Id
    private long id;
    private String name;
    private String color;
    private Material material;
    private String size;

    public Scarf(String name, String color, String size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    public Scarf() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    public Material getMaterial() {
        return material;
    }

    public String getSize() {
        return size;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Scarf{" + "id=" + id + ", name=" + name + ", color=" + color + ", material=" + material + ", size=" + size + '}';
    }
}
