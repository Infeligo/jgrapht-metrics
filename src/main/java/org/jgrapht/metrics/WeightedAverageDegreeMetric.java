package org.jgrapht.metrics;


public class WeightedAverageDegreeMetric<V,E> {

    protected WeightedDegreeGraph<V,E> graph;

    public WeightedAverageDegreeMetric(WeightedDegreeGraph<V, E> graph) {
        this.graph = graph;
    }

    public AverageDegreeResult calculate() {
        double totalInDegree = graph.vertexSet().stream().mapToDouble(v -> graph.weightedInDegreeOf(v)).sum();
        double totalOutDegree = graph.vertexSet().stream().mapToDouble(v -> graph.weightedOutDegreeOf(v)).sum();
        double totalDegree = totalInDegree + totalOutDegree;
        int vertexCount = graph.vertexSet().size();
        double averageDegree = totalDegree / vertexCount;
        double averageInDegree = totalInDegree / vertexCount;
        double averageOutDegree = totalOutDegree / vertexCount;
        return new AverageDegreeResult(averageDegree, averageInDegree, averageOutDegree);
    }


}
