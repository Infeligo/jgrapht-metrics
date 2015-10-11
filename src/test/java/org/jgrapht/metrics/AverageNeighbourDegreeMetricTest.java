package org.jgrapht.metrics;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AverageNeighbourDegreeMetricTest {

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
    public void testAverageNeighbourDegreeCalculation() {
        UndirectedGraph<String, DefaultEdge> graph1 = getGraph1();
        UndirectedGraph<String, DefaultEdge> graph2 = getGraph2();
        UndirectedGraph<String, DefaultEdge> graph3 = getGraph3();

        AverageNeighbourDegreeResult<String> result1 = new AverageNeighbourDegreeMetric<>(graph1).calculate();
        AverageNeighbourDegreeResult<String> result2 = new AverageNeighbourDegreeMetric<>(graph2).calculate();
        AverageNeighbourDegreeResult<String> result3 = new AverageNeighbourDegreeMetric<>(graph3).calculate();

        assertEquals(2.0, result1.get("1"), 0.001);
        assertEquals(1.5, result1.get("2"), 0.001);
        assertEquals(1.5, result1.get("3"), 0.001);
        assertEquals(2.0, result1.get("4"), 0.001);

        assertEquals(1.5, result2.get("1"), 0.001);
        assertEquals(4.0, result2.get("2"), 0.001);
        assertEquals(4.0, result2.get("3"), 0.001);
        assertEquals(4.0, result2.get("4"), 0.001);
        assertEquals(2.0, result2.get("5"), 0.001);
        assertEquals(3.0, result2.get("6"), 0.001);
        assertEquals(3.0, result2.get("7"), 0.001);

        assertEquals(3.0, result3.get("1"), 0.001);
        assertEquals(3.0, result3.get("2"), 0.001);
        assertEquals(3.0, result3.get("3"), 0.001);
        assertEquals(3.0, result3.get("4"), 0.001);
    }

}
