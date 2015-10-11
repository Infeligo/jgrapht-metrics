package org.jgrapht.metrics;


import org.jgrapht.GraphPath;
import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.FloydWarshallShortestPaths;

public class AveragePathLengthMetric<V, E> {

    protected UndirectedGraph<V, E> graph;

    public AveragePathLengthMetric(UndirectedGraph<V, E> graph) {
        this.graph = graph;
    }

    public AveragePathLengthResult calculate() {
        FloydWarshallShortestPaths<V, E> shortestPaths = new FloydWarshallShortestPaths(Graphs.undirectedGraph(graph));
        int totalShortestPathLength = 0;
        int longestShortestPathLength = 0;
        GraphPath<V, E> longestShortestPath = null;
        int totalPathCount = 0;

        for (V vertex : graph.vertexSet()) {
            for (GraphPath<V, E> path : shortestPaths.getShortestPaths(vertex)) {
                int thisPathLength = path.getEdgeList().size();
                if (longestShortestPathLength < thisPathLength) {
                    longestShortestPath = path;
                    longestShortestPathLength = thisPathLength;
                }
                totalShortestPathLength += path.getEdgeList().size();
                totalPathCount++;
            }
        }
        double averagePathLength = (double) totalShortestPathLength / totalPathCount;
        int diameter = (int) shortestPaths.getDiameter();
        return new AveragePathLengthResult(averagePathLength, diameter, longestShortestPath);
    }

}
