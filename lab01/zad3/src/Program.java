public class Program {
    public static void main(String[] args) {

        int age = 1000000000;

        System.out.println("Wiek w latach: "+Planet.MERCURY.ageInYears(age));
        System.out.println("Wiek w latach: "+Planet.VENUS.ageInYears(age));
        System.out.println("Wiek w latach: "+Planet.EARTH.ageInYears(age));
        System.out.println("Wiek w latach: "+Planet.MARS.ageInYears(age));
        System.out.println("Wiek w latach: "+Planet.JUPITER.ageInYears(age));
        System.out.println("Wiek w latach: "+Planet.SATURN.ageInYears(age));
        System.out.println("Wiek w latach: "+Planet.URANUS.ageInYears(age));
        System.out.println("Wiek w latach: "+Planet.NEPTUNE.ageInYears(age));
    }
}
