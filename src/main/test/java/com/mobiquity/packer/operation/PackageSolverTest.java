package com.mobiquity.packer.operation;

import com.mobiquity.packer.model.Package;
import com.mobiquity.packer.model.PackageItem;
import com.mobiquity.packer.model.PackageResult;
import org.junit.jupiter.api.Test;

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
        packageItems.add(new PackageItem(1, 53.38, 45));
        packageItems.add(new PackageItem(2, 88.62, 98));
        packageItems.add(new PackageItem(3, 78.48, 3));
        packageItems.add(new PackageItem(4, 72.3, 76));
        packageItems.add(new PackageItem(5, 30.18,9));
        packageItems.add(new PackageItem(6, 46.34, 48));
        Package pack = new Package(81, packageItems);
        PackageResult result = PackageSolver.solve(pack);

        assertNotNull(result);
        assertNotNull(result.getSelectedItems());
        assertEquals(1, result.getSelectedItems().size());
        assertEquals(4, result.getSelectedItems().get(0).getIndex());
        assertEquals(76, result.getScore());
    }
}