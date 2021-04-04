package com.mobiquity.packer.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * The Package is the class comprises capacity and
 * package items of given problem.
 */
public final class Package {

    private final BigDecimal capacity;
    private final List<PackageItem> packageItems;

    /**
     * Instantiates a new Package.
     *
     * @param capacity the capacity
     * @param packages the package items
     */
    public Package(BigDecimal capacity, List<PackageItem> packages) {
        this.capacity = capacity;
        this.packageItems = packages;
    }

    /**
     * Gets capacity.
     *
     * @return the capacity
     */
    public BigDecimal getCapacity() {
        return capacity;
    }

    /**
     * Gets package items.
     *
     * @return the package items
     */
    public List<PackageItem> getPackageItems() {
        return packageItems;
    }

}
