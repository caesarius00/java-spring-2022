package pl.edu.ug.ckwella.kolokwium.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties("scarfs")
@Entity
public class Material {
    @Id
    private long id;
    private String name;
    private int density; // g/cm^3
    private int thickness; //1 = 0.01 mm

    private List<Scarf> scarfs;


    public Material(String name, int density, int thickness) {
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

    @OneToMany(mappedBy = "material", fetch = FetchType.EAGER)
    public List<Scarf> getScarfs() {
        return scarfs;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDensity(int density) {
        this.density = density;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public void setScarfs(List<Scarf> scarfs) {
        this.scarfs = scarfs;
    }

    @Override
    public String toString() {
        //return "Material{" + "name=" + name + ", density=" + density + ", thickness=" + thickness + "scarfs=" + scarfs + '}';
        return "Material{" + "name=" + name + ", density=" + density + ", thickness=" + thickness + '}';
    }
}
