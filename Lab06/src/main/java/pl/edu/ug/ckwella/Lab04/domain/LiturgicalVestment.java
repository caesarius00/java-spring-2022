package pl.edu.ug.ckwella.Lab04.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LiturgicalVestment {
    @Id
    private long id;
    private String name;
    private String primaryColor;
    private String secondaryColor;
    private String material;
    private String liningMaterial;
    private String cutType;
    private String size;
    private String description;

    public LiturgicalVestment(long ID, String name, String primaryColor, String secondaryColor, String material, String liningMaterial, String cutType, String size, String description) {
        this.id = ID;
        this.name = name;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.material = material;
        this.liningMaterial = liningMaterial;
        this.cutType = cutType;
        this.size = size;
        this.description = description;
    }

    public LiturgicalVestment() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public void setSecondaryColor(String secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setLiningMaterial(String liningMaterial) {
        this.liningMaterial = liningMaterial;
    }

    public void setCutType(String cutType) {
        this.cutType = cutType;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public String getMaterial() {
        return material;
    }

    public String getLiningMaterial() {
        return liningMaterial;
    }

    public String getCutType() {
        return cutType;
    }

    public String getSize() {
        return size;
    }

    public String getDescription() {
        return description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    //to string
    @Override
    public String toString() {
        return "LiturgicalVestment{" + "ID=" + id +
                ", name=" + name +
                ", primaryColor=" + primaryColor +
                ", secondaryColor=" + secondaryColor +
                ", material=" + material +
                ", liningMaterial=" + liningMaterial +
                ", cutType=" + cutType +
                ", size=" + size +
                ", description=" + description + '}';
    }

}
