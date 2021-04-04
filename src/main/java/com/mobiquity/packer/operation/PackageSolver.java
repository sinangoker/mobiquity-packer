package com.mobiquity.packer.operation;

import com.mobiquity.packer.model.Package;
import com.mobiquity.packer.model.PackageItem;
import com.mobiquity.packer.model.PackageResult;
import org.apache.commons.lang3.SerializationUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Package solver that applies the recursive solution
 * and return solution as a PackageResult instance.
 */
public class PackageSolver {

    private PackageSolver() {
    }

    /**
     * Solves package challenge and returns result.
     *
     * Based on the recursive solution of the 0-1 Knapsack problem
     * https://en.wikipedia.org/wiki/Knapsack_problem#Dynamic_programming_in-advance_algorithm
     *
     * @param pack the pack
     * @return the package result
     */
    public static PackageResult solve(Package pack) {
        //sorted by unit cost
        List<PackageItem> sortedItems = pack.getPackageItems().stream()
                .sorted(Comparator.comparingDouble(PackageItem::getWeight))
                .collect(Collectors.toList());

        return knapSack(pack.getCapacity(), sortedItems, sortedItems.size());
    }

    private static PackageResult knapSack(double capacity, List<PackageItem> packageItems, int packIndex) {

        if (packIndex == 0 || capacity == 0)
            return new PackageResult(0);

        int itemIndex = packIndex - 1;
        PackageItem packageItem = packageItems.get(itemIndex);

        // If weight of the nth item is more
        // than Knapsack capacity, then
        // this item cannot be included
        // in the optimal solution
        if (packageItem.getWeight() > capacity) {
            return knapSack(capacity, packageItems, itemIndex);
        } else {
            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
            PackageResult resultIncludingNth = knapSack(capacity - packageItem.getWeight(), packageItems, itemIndex);
            resultIncludingNth.addCost(packageItem.getCost());

            PackageResult resultWithoutNth = knapSack(capacity, packageItems, itemIndex);


            if (resultIncludingNth.getScore() > resultWithoutNth.getScore()
                    && resultIncludingNth.getSelectedItems().size() < 15) {
                // There might be up to 15 items you need to choose from
                resultIncludingNth.selectItem(packageItem);
                // creates clone of result
                return SerializationUtils.clone(resultIncludingNth);
            }
            return SerializationUtils.clone(resultWithoutNth);
        }
    }

}
