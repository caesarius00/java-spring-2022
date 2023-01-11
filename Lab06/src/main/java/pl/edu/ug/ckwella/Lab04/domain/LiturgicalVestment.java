package pl.edu.ug.ckwella.Lab04.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class LiturgicalVestment {
    @Id
    private long id;
    private String name;
    private String primaryColor;
    private String secondaryColor;
    private Material material;
    private Material liningMaterial;
    private String cutType;
    private String size;
    private Description description;

    private List<LiturgicalFunction> users;

    public LiturgicalVestment(long ID, String name, String primaryColor, String secondaryColor, String cutType, String size) {
        this.id = ID;
        this.name = name;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.cutType = cutType;
        this.size = size;
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

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setLiningMaterial(Material liningMaterial) {
        this.liningMaterial = liningMaterial;
    }

    public void setCutType(String cutType) {
        this.cutType = cutType;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setDescription(Description description) {
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    public Material getMaterial() {
        return material;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    public Material getLiningMaterial() {
        return liningMaterial;
    }

    public String getCutType() {
        return cutType;
    }

    public String getSize() {
        return size;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Description getDescription() {
        return description;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @ManyToMany(cascade = CascadeType.PERSIST) //po dodaniu szaty ludzie zostaną dodani do bazy jeśli nie istnieli
    public List<LiturgicalFunction> getUsers() {
        return users;
    }

    public void setUsers(List<LiturgicalFunction> users) {
        this.users = users;
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
