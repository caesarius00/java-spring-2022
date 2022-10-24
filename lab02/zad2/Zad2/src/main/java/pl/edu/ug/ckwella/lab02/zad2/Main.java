package pl.edu.ug.ckwella.lab02.zad2;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

public class Main {
    public static void main(String[] args) {

        double [] tab = {1.3,4.6,1.1,17.0,94.7};

        SummaryStatistics n = new SummaryStatistics();
        for(int i=0; i<tab.length; i++){
            n.addValue(tab[i]);
        }
        System.out.println("Mean: " + Compute.mean(n));
        System.out.println("Standard deviation: " + Compute.standardDeviation(n));
        System.out.println("Variance: " + Compute.variance(n));
    }
}