package org.jgrapht.metrics;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssortativityCoefficientMetricTest {

    private UndirectedGraph<String, DefaultEdge> getGraph1() {
        UndirectedGraph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addEdge("1", "2");
        graph.addEdge("2", "3");
        graph.addEdge("3", "4");
        return graph;
    }

    public UndirectedGraph<String, DefaultEdge> getGraph2() {
        UndirectedGraph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");
        graph.addVertex("7");
        graph.addEdge("1", "2");
        graph.addEdge("1", "3");
        graph.addEdge("1", "4");
        graph.addEdge("1", "5");
        graph.addEdge("5", "6");
        graph.addEdge("5", "7");
        return graph;
    }

    public UndirectedGraph<String, DefaultEdge> getGraph3() {
        UndirectedGraph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addEdge("1", "2");
        graph.addEdge("1", "3");
        graph.addEdge("1", "4");
        graph.addEdge("2", "3");
        graph.addEdge("2", "4");
        graph.addEdge("3", "4");
        return graph;
    }

    @Test
    public void testAssortativityCoefficientCalculation() {
        assertEquals(-0.5, new AssortativityCoefficientMetric<>(getGraph1()).calculate(), 0.001);
        assertEquals(-0.714285714286, new AssortativityCoefficientMetric<>(getGraph2()).calculate(), 0.001);
        assertEquals(Double.NaN, new AssortativityCoefficientMetric<>(getGraph3()).calculate(), 0.001);
    }

}
