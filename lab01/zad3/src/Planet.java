import static java.lang.Math.round;

public enum Planet {
    MERCURY (0.2408467),
    VENUS   (0.61519726),
    EARTH   (1),
    MARS    (1.8808158),
    JUPITER (11.862615),
    SATURN  (29.447498),
    URANUS  (84.016846),
    NEPTUNE (164.79132);

    private final double multiplier;

    Planet(double multiplier){
        this.multiplier = multiplier;
    }

    public double ageInYears(int age){
        return round(age/(multiplier*31557600)* 100.0)/100.0;
    }
}
