package org.jgrapht.metrics;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocalClusteringCoefficientMetricTest {

    Graph<String,DefaultEdge> graph;

    @Before
    public void before() {
        graph = new SimpleGraph<>(DefaultEdge.class);
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addEdge("1", "2");
        graph.addEdge("1", "3");
        graph.addEdge("1", "4");
    }

    @Test
    public void testLocalClusteringCoefficientThreeThirds() {
        graph.addEdge("2", "3");
        graph.addEdge("2", "4");
        graph.addEdge("3", "4");
        LocalClusteringCoefficientResult<String> result = new LocalClusteringCoefficientMetric<>(graph).calculate();
        assertEquals(1.0, result.get("1"), 0.0001);
    }

    @Test
    public void testLocalClusteringCoefficientOneThird() {
        graph.addEdge("3", "4");
        LocalClusteringCoefficientResult<String> result = new LocalClusteringCoefficientMetric<>(graph).calculate();
        assertEquals(0.3333, result.get("1"), 0.0001);
    }

    @Test
    public void testLocalClusteringCoefficientZero() {
        LocalClusteringCoefficientResult<String> result = new LocalClusteringCoefficientMetric<>(graph).calculate();
        assertEquals(0.0, result.get("1"), 0.0001);
    }

    @Test
    public void testLocalClusteringOfDegreeZero() {
        Graph<String,DefaultEdge> graph2 = new SimpleGraph<>(DefaultEdge.class);
        graph2.addVertex("1");
        graph2.addVertex("2");
        graph2.addVertex("3");
        LocalClusteringCoefficientResult<String> result = new LocalClusteringCoefficientMetric<>(graph2).calculate();
        assertEquals(0.0, result.get("1"), 0.0001);
    }

    @Test
    public void testLocalClusteringOfDegreeOne() {
        Graph<String,DefaultEdge> graph2 = new SimpleGraph<>(DefaultEdge.class);
        graph2.addVertex("1");
        graph2.addVertex("2");
        graph2.addVertex("3");
        graph2.addEdge("1", "2");
        LocalClusteringCoefficientResult<String> result = new LocalClusteringCoefficientMetric<>(graph2).calculate();
        assertEquals(0.0, result.get("1"), 0.0001);
    }

}
