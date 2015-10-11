package org.jgrapht.metrics;

import org.jgrapht.GraphPath;

public class AveragePathLengthResult<V,E> {

    protected double averagePathLength;
    protected int diameter;
    protected GraphPath<V,E> longestShortestPath;

    protected AveragePathLengthResult(double averagePathLength, int diameter, GraphPath<V,E> longestShortestPath) {
        this.averagePathLength = averagePathLength;
        this.diameter = diameter;
        this.longestShortestPath = longestShortestPath;
    }

    public double getAveragePathLength() {
        return averagePathLength;
    }

    public int getDiameter() {
        return diameter;
    }

    public GraphPath<V,E> getLongestShortestPath() {
        return longestShortestPath;
    }
}
