package com.mobiquity.packer.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The PackageResult is the class comprises score
 * and selected package items.
 */
public class PackageResult implements Serializable {

    private double score;
    private final List<PackageItem> selectedItems;

    /**
     * Instantiates a new Package result.
     *
     * @param score the score
     */
    public PackageResult(double score) {
        this.score = score;
        this.selectedItems = new ArrayList<>();
    }

    /**
     * Gets total score.
     *
     * @return the score
     */
    public double getScore() {
        return score;
    }

    /**
     * Gets selected items.
     *
     * @return the selected items
     */
    public List<PackageItem> getSelectedItems() {
        return selectedItems;
    }

    /**
     * Add given item to selected items list.
     *
     * @param packageItem the package items
     */
    public void selectItem(PackageItem packageItem) {
        if (!getSelectedItems().contains(packageItem)) {
            getSelectedItems().add(packageItem);
        }
    }

    /**
     * Adds cost to total score.
     *
     * @param cost the cost
     */
    public void addCost(double cost) {
        this.score += cost;
    }

}
