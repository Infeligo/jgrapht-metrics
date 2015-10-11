package org.jgrapht.metrics;


public class AverageDegreeResult {

    protected double averageDegree;
    protected double averageInDegree;
    protected double averageOutDegree;

    public AverageDegreeResult(double averageDegree, double averageInDegree, double averageOutDegree) {
        this.averageDegree = averageDegree;
        this.averageInDegree = averageInDegree;
        this.averageOutDegree = averageOutDegree;
    }

    public double getAverageDegree() {
        return averageDegree;
    }

    public double getAverageInDegree() {
        return averageInDegree;
    }

    public double getAverageOutDegree() {
        return averageOutDegree;
    }
}
