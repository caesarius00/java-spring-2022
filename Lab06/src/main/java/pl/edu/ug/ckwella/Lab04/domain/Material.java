package pl.edu.ug.ckwella.Lab04.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties(value={"liturgicalVestmentsWhereMaterial", "liturgicalVestmentsWhereLiningMaterial"})
@Entity
public class Material {
    private long id;
    private String name;
    private double density; // g/cm^3
    private double thickness; //1 = 0.01 mm

    private List<LiturgicalVestment> liturgicalVestmentsWhereMaterial;

    private List<LiturgicalVestment> liturgicalVestmentsWhereLiningMaterial;


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

    @OneToMany(mappedBy = "material", fetch = FetchType.EAGER)
    public List<LiturgicalVestment> getLiturgicalVestmentsWhereMaterial() {
        return liturgicalVestmentsWhereMaterial;
    }

    @OneToMany(mappedBy = "liningMaterial", fetch = FetchType.EAGER)
    public List<LiturgicalVestment> getLiturgicalVestmentsWhereLiningMaterial() {
        return liturgicalVestmentsWhereLiningMaterial;
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

    public void setLiturgicalVestmentsWhereMaterial(List<LiturgicalVestment> liturgicalVestmentsWhereMaterial) {
        this.liturgicalVestmentsWhereMaterial = liturgicalVestmentsWhereMaterial;
    }

    public void setLiturgicalVestmentsWhereLiningMaterial(List<LiturgicalVestment> liturgicalVestmentsWhereLiningMaterial) {
        this.liturgicalVestmentsWhereLiningMaterial = liturgicalVestmentsWhereLiningMaterial;
    }

    @Override
    public String toString() {
        return "Material{" + "name=" + name + ", density=" + density + ", thickness=" + thickness + "liturgicalVestments=" + liturgicalVestmentsWhereMaterial + '}';
        //return "Material{" + "name=" + name + ", density=" + density + ", thickness=" + thickness + '}';
    }
}
