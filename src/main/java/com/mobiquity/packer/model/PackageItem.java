package com.mobiquity.packer.model;

import java.io.Serializable;

/**
 * The PackageItem is the class comprises index
 * weight and cost.
 */
public final class PackageItem implements Serializable {

    private final int index;
    private final double weight;
    private final double cost;

    /**
     * Instantiates a new Package ıtem.
     *
     * @param index  the index
     * @param weight the weight
     * @param cost   the cost
     */
    public PackageItem(int index, double weight, double cost) {
        this.index = index;
        this.weight = weight;
        this.cost = cost;
    }

    /**
     * Gets ındex.
     *
     * @return the ındex
     */
    public int getIndex() {
        return index;
    }

    /**
     * Gets String value of index.
     *
     * @return the string value of index
     */
    public String getIndexText() {
        return String.valueOf(getIndex());
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Gets cost.
     *
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

}
