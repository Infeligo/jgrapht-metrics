package org.jgrapht.metrics;

import org.jgrapht.UndirectedGraph;

public class AssortativityCoefficientMetric<V, E> {

    protected UndirectedGraph<V, E> graph;

    public AssortativityCoefficientMetric(UndirectedGraph<V, E> graph) {
        this.graph = graph;
    }

    /**
     * Implementation as described in "Networks" by Mark Newman (p267)
     */
    public double calculate() {
        double edgeCount = graph.edgeSet().size();
        double n1 = 0, n2 = 0, dn = 0;

        for (E e : graph.edgeSet()) {
            int d1 = graph.degreeOf(graph.getEdgeSource(e));
            int d2 = graph.degreeOf(graph.getEdgeTarget(e));

            n1 += d1 * d2;
            n2 += d1 + d2;
            dn += d1 * d1 + d2 * d2;
        }
        n1 /= edgeCount;
        n2 = (n2 / (2 * edgeCount)) * (n2 / (2 * edgeCount));
        dn /= (2 * edgeCount);

        return (n1 - n2) / (dn - n2);
    }

}
