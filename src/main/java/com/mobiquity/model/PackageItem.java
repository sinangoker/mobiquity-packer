package com.mobiquity.model;

public final class PackageItem {

    private final int index;
    private final double weight;
    private final double cost;

    public PackageItem(int index, double weight, double cost) {
        this.index = index;
        this.weight = weight;
        this.cost = cost;
    }

    public int getIndex() {
        return index;
    }

    public double getWeight() {
        return weight;
    }

    public double getCost() {
        return cost;
    }
}
