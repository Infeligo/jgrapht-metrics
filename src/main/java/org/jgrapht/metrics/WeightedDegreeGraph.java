package org.jgrapht.metrics;

import org.jgrapht.Graph;

public interface WeightedDegreeGraph<V,E> extends Graph<V,E> {

    double weightedDegreeOf(V vertex);

    double weightedInDegreeOf(V vertex);

    double weightedOutDegreeOf(V vertex);

}
