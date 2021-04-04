package com.mobiquity.packer.operation;

import com.mobiquity.packer.model.Package;
import com.mobiquity.packer.model.PackageItem;
import com.mobiquity.packer.model.PackageResult;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The type Package solver test.
 */
class PackageSolverTest {

    /**
     * Test for Package solver.
     */
    @Test
    void solve() {
        List<PackageItem> packageItems = new ArrayList<>();
        packageItems.add(createPackageItem(1, 53.38, 45));
        packageItems.add(createPackageItem(2, 88.62, 98));
        packageItems.add(createPackageItem(3, 78.48, 3));
        packageItems.add(createPackageItem(4, 72.3, 76));
        packageItems.add(createPackageItem(5, 30.18, 9));
        packageItems.add(createPackageItem(6, 46.34, 48));
        Package pack = new Package(new BigDecimal(81), packageItems);
        PackageResult result = PackageSolver.solve(pack);

        assertNotNull(result);
        assertNotNull(result.getSelectedItems());
        assertEquals(1, result.getSelectedItems().size());
        assertEquals(4, result.getSelectedItems().get(0).getIndex());
        assertEquals(new BigDecimal(76), result.getScore());
    }

    private PackageItem createPackageItem(int index, double weight, double cost) {
        return new PackageItem(index, new BigDecimal(weight), new BigDecimal(cost));
    }
}