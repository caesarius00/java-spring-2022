package pl.edu.ug.ckwella.lab11.reactive;


public class Material {
    private String name;
    private double density; // g/cm^3
    private double thickness; //1 = 0.01 mm


    public Material(String name, double density, double thickness) {
        this.name = name;
        this.density = density;
        this.thickness = thickness;
    }

    public Material() {
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


    public void setName(String name) {
        this.name = name;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    @Override
    public String toString() {
        //return "Material{" + "name=" + name + ", density=" + density + ", thickness=" + thickness + "liturgicalVestments=" + liturgicalVestmentsWhereMaterial + '}';
        return "Material{" + "name=" + name + ", density=" + density + ", thickness=" + thickness + '}';
    }
}
