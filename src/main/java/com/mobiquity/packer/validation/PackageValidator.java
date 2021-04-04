package com.mobiquity.packer.validation;

import com.mobiquity.exception.APIException;

import java.math.BigDecimal;
import java.util.List;

/**
 * Validation methods for Package content.
 */
public class PackageValidator {

    private PackageValidator() {
    }

    /**
     * Validate cost.
     *
     * @param cost the cost
     * @throws APIException the apı exception
     */
    public static void validateCost(BigDecimal cost) throws APIException {
        if (cost.compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new APIException("Max cost of a package can be 100");
        }
    }

    /**
     * Validate weight.
     *
     * @param weight the weight
     * @throws APIException the apı exception
     */
    public static void validateWeight(BigDecimal weight) throws APIException {
        if (weight.compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new APIException("Max weight of a package can be 100");
        }
    }

    /**
     * Validate input file content.
     *
     * @param lines the lines
     * @throws APIException the api exception
     */
    public static void validateInputFileContent(List<String> lines) throws APIException {
        if (lines.isEmpty()) {
            throw new APIException("Input file is empty");
        }
    }

    /**
     * Validate package details.
     *
     * @param packageDetails the package details
     * @throws APIException the apı exception
     */
    public static void validatePackageDetails(String[] packageDetails) throws APIException {
        if (packageDetails.length == 0) {
            throw new APIException("PackageDetails does not exist in input content");
        }
    }
}
