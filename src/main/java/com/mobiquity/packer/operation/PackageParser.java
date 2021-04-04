package com.mobiquity.packer.operation;

import com.mobiquity.exception.APIException;
import com.mobiquity.packer.model.Package;
import com.mobiquity.packer.model.PackageItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Package parser.
 */
public class PackageParser {

    private PackageParser() {
    }

    /**
     * Parse given string and create Package item.
     *
     * @param packageString the package string
     * @return the package
     * @throws APIException          the api exception
     * @throws NumberFormatException the api exception
     */
    public static Package parse(String packageString) throws APIException, NumberFormatException {
        String[] packageParts = packageString.strip().split(" : ");
        if (packageParts.length == 2) {
            return generatePackage(packageParts);
        }
        throw new APIException("Error while parsing package : packageParts");
    }

    private static Package generatePackage(String[] packageParts) throws APIException {
        BigDecimal capacity = new BigDecimal(packageParts[0]);
        List<PackageItem> packages = new ArrayList<>();
        String[] packageDetails = packageParts[1].strip().split(" ");
        for (String packageDetail : packageDetails) {
            packages.add(generatePackageItemByDetail(packageDetail));
        }
        return new Package(capacity, packages);
    }

    private static PackageItem generatePackageItemByDetail(String packageDetail) throws APIException {
        String[] packageFields = packageDetail.replace("(", "")
                .replace(")", "")
                .replace("€", "")
                .strip().split(",");

        if (packageFields.length == 3) {
            int index = Integer.parseInt(packageFields[0]);
            BigDecimal weight = new BigDecimal(packageFields[1]);
            BigDecimal cost = new BigDecimal(packageFields[2]);
            validateWeight(weight);
            validateCost(cost);
            return new PackageItem(index, weight, cost);
        }
        throw new APIException("Error while parsing package : packageDetail");
    }

    private static void validateCost(BigDecimal cost) throws APIException {
        if (cost.compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new APIException("Max cost of a package can be 100");
        }
    }

    private static void validateWeight(BigDecimal weight) throws APIException {
        if (weight.compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new APIException("Max weight of a package can be 100");
        }
    }

    /**
     * Generates result string from selected items.
     *
     * @param items the selected items
     * @return the result string
     */
    public static String generateResultString(List<PackageItem> items) {
        String result = "-";
        if (!items.isEmpty()) {
            result = items.stream().sorted(Comparator.comparingInt(PackageItem::getIndex))
                    .map(PackageItem::getIndexText)
                    .collect(Collectors.joining(","));
        }
        return result;
    }
}
