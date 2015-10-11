package org.jgrapht.metrics;


import org.jgrapht.DirectedGraph;

public class AverageDegreeMetric<V,E> {

    protected DirectedGraph<V,E> graph;

    public AverageDegreeMetric(DirectedGraph<V,E> graph) {
        this.graph = graph;
    }

    public AverageDegreeResult calculate() {
        int totalInDegree = graph.vertexSet().stream().mapToInt(v -> graph.inDegreeOf(v)).sum();
        int totalOutDegree = graph.vertexSet().stream().mapToInt(v -> graph.outDegreeOf(v)).sum();
        int totalDegree = totalInDegree + totalOutDegree;
        int vertexCount = graph.vertexSet().size();
        double averageDegree = (double) totalDegree / vertexCount;
        double averageInDegree = (double) totalInDegree / vertexCount;
        double averageOutDegree = (double) totalOutDegree / vertexCount;
        return new AverageDegreeResult(averageDegree, averageInDegree, averageOutDegree);
    }


}
