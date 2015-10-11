package org.jgrapht.metrics;

import java.util.*;

public class LocalClusteringCoefficientResult<V> {

    protected Map<V,Double> raw;
    protected double averageClusteringCoefficient;

    protected LocalClusteringCoefficientResult(Map<V, Double> raw) {
        this.raw = raw;
        calculateAverageClusteringCoefficient();
    }

    private void calculateAverageClusteringCoefficient() {
        double total = 0.0;
        for (Double value : raw.values()) {
            if (value != null) {
                total += value;
            }
        }
        averageClusteringCoefficient = total / raw.size();
    }

    public Double get(V v) {
        return raw.get(v);
    }

    public List<Map.Entry<V,Double>> getSorted() {
        List<Map.Entry<V,Double>> entryList = new ArrayList<>(raw.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<V, Double>>() {
            @Override
            public int compare(Map.Entry<V, Double> o1, Map.Entry<V, Double> o2) {
                // Note that the order is reversed
                return Double.compare(o2.getValue(), o1.getValue());
            }
        });
        return entryList;
    }

    public double getAverageClusteringCoefficient() {
        return averageClusteringCoefficient;
    }
}
