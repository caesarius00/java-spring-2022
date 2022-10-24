package pl.edu.ug.ckwella.lab02.zad2;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;


public class Statistics {
    public static double mean(SummaryStatistics x){
        return x.getMean();
    }
    public static double standardDeviation(SummaryStatistics x){
        return x.getStandardDeviation();
    }
    public static double variance(SummaryStatistics x){
        return x.getVariance();
    }
}
