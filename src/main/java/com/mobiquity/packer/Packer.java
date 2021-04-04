package com.mobiquity.packer;

import com.mobiquity.exception.APIException;
import com.mobiquity.packer.model.Package;
import com.mobiquity.packer.model.PackageResult;
import com.mobiquity.packer.operation.PackageParser;
import com.mobiquity.packer.operation.PackageSolver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * The Packer class that .
 */
public class Packer {

    private Packer() {
    }

    /**
     * Gets a filepath as parameter, reads given file in UTF-8 format,
     * parses and solves the package challenge problem.
     *
     * @param filePath the file path
     * @return the string
     * @throws APIException the api exception
     */
    public static String pack(String filePath) throws APIException {
        List<String> results = new ArrayList<>();
        try {
            // read lines of given file in UTF-8 format
            List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);

            for (String line : lines) {
                // parse given line of case
                Package pack = PackageParser.parse(line);

                // solve package item optimization
                PackageResult packageResult = PackageSolver.solve(pack);

                // generate results for case
                String result = PackageParser.generateResultString(packageResult.getSelectedItems());
                results.add(result);
            }

        } catch (IOException e) {
            throw new APIException("Error while reading input file", e);
        } catch (NumberFormatException e) {
            throw new APIException("Error while parsing input file", e);
        }
        return String.join("\n", results);
    }
}
