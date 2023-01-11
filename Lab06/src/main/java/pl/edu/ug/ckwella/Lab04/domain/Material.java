package pl.edu.ug.ckwella.Lab04.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Material {
    private long id;
    private String name;
    private double density;
    private double thickness;

    private List<LiturgicalVestment> liturgicalVestments;

    public Material(String name, double density, double thickness) {
        this.name = name;
        this.density = density;
        this.thickness = thickness;
    }

    public Material() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getDensity() {
        return density;
    }

    public double getThickness() {
        return thickness;
    }

    @OneToMany(mappedBy = "material")
    public List<LiturgicalVestment> getLiturgicalVestments() {
        return liturgicalVestments;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public void setLiturgicalVestments(List<LiturgicalVestment> liturgicalVestments) {
        this.liturgicalVestments = liturgicalVestments;
    }

    @Override
    public String toString() {
        return "Material{" + "name=" + name + ", density=" + density + ", thickness=" + thickness + "liturgicalVestments=" + liturgicalVestments + '}';
    }
}
