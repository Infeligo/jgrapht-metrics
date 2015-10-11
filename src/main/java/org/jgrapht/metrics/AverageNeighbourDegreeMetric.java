package org.jgrapht.metrics;

import org.jgrapht.UndirectedGraph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.jgrapht.Graphs.neighborListOf;

public class AverageNeighbourDegreeMetric<V, E> {

    protected UndirectedGraph<V, E> graph;

    public AverageNeighbourDegreeMetric(UndirectedGraph<V, E> graph) {
        this.graph = graph;
    }

    public AverageNeighbourDegreeResult calculate() {
        Map<V, Double> averageDegrees = new HashMap<>();
        for (V vertex : graph.vertexSet()) {
            averageDegrees.put(vertex, calculateVertex(vertex));
        }
        return new AverageNeighbourDegreeResult(averageDegrees);
    }

    protected double calculateVertex(V vertex) {
        List<V> neighbours = neighborListOf(graph, vertex);
        int totalDegree = 0;
        for (V neighbour : neighbours) {
            totalDegree += graph.degreeOf(neighbour);
        }
        return (double) totalDegree / neighbours.size();
    }
}
