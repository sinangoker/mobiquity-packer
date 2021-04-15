package com.mobiquity.packer.operation;

import com.mobiquity.exception.APIException;
import com.mobiquity.packer.model.Package;
import com.mobiquity.packer.model.PackageItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Package parser test.
 */
class PackageParserTest {

    /**
     * Unit test for Parse operation.
     */
    @Test
    void parse() {
        String packageString = "81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)";
        try {
            Package pack = new PackageParser().parse(packageString);

            assertEquals(new BigDecimal(81), pack.getCapacity());
            assertNotNull(pack.getPackageItems());
            assertEquals(6, pack.getPackageItems().size());
        } catch (APIException e) {
            fail("Error while parsing : " + e.getMessage());
        }
    }

    /**
     * Unit test for result string generation operation.
     */
    @Test
    void generateResultString() {
        List<PackageItem> packageItems = new ArrayList<>();
        packageItems.add(new PackageItem(1, new BigDecimal(10), new BigDecimal(5)));
        packageItems.add(new PackageItem(2, new BigDecimal(15), new BigDecimal(8)));
        packageItems.add(new PackageItem(3, new BigDecimal(12), new BigDecimal(10)));
        String result = PackageParser.generateResultString(packageItems);
        assertEquals("1,2,3", result);
    }
}