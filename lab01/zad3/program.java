import static java.lang.Math.round;

public class program {
    public static void main(String[] args) {

        int MERKURY = 0, WENUS=1, ZIEMIA=2, MARS=3, JOWISZ=4, SATURN=5, URAN=6, NEPTUN=7;

        double[] mnoznik = new double[]{0.2408467, 0.61519726, 1, 1.8808158, 11.862615, 29.447498, 84.016846, 164.79132};

        int wiek = 1000000000;
        int planeta = ZIEMIA;

        System.out.println("Wiek w latach: "+round(wiek/(mnoznik[planeta]*31557600)* 100.0)/100.0);
    }
}
