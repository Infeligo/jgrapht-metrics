package org.jgrapht.metrics;

import org.jgrapht.Graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.jgrapht.Graphs.*;

/**
 * Calculates clustering coefficients for vertices treating graph as undirected
 */
public class LocalClusteringCoefficientMetric<V,E> {

    protected Graph<V,E> graph;

    public LocalClusteringCoefficientMetric(Graph<V, E> graph) {
        this.graph = graph;
    }

    public LocalClusteringCoefficientResult<V> calculate() {
        Map<V,Double> coefficients = new HashMap<>(graph.vertexSet().size());
        for (V vertex : graph.vertexSet()) {
            coefficients.put(vertex, calculateVertex(vertex));
        }
        return new LocalClusteringCoefficientResult<>(coefficients);
    }

    private double calculateVertex(V vertex) {
        List<V> neighbours = neighborListOf(graph, vertex);
        if (neighbours.size() < 2) return 0.0;
        int edgesMax = neighbours.size() * (neighbours.size() - 1);
        int edgesActual = 0;
        for (V n1 : neighbours) {
            for (V n2 : neighbours) {
                if (!n1.equals(n2)) {
                    if (graph.containsEdge(n1, n2)) {
                        edgesActual++;
                    }
                }
            }
        }
        return (double)edgesActual / edgesMax;
    }



}
