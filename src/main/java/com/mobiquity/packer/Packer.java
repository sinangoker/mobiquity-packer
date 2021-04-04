package com.mobiquity.packer;

import com.mobiquity.exception.APIException;
import com.mobiquity.packer.model.Package;
import com.mobiquity.packer.model.PackageResult;
import com.mobiquity.packer.operation.PackageParser;
import com.mobiquity.packer.operation.PackageSolver;
import com.mobiquity.packer.validation.PackageValidator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * The Packer class that solves the Package	Challenge problem.
 */
public class Packer {

    private Packer() {
    }

    /**
     * Gets a filepath as parameter, reads the given file in UTF-8 format,
     * parses and solves the package challenge problem.
     *
     * @param filePath the file path
     * @return the solution string
     * @throws APIException the api exception
     */
    public static String pack(String filePath) throws APIException {
        List<String> results = new ArrayList<>();

        // read lines of the given file in UTF-8 format
        // to ensures that the resource is closed at the end of the process
        try (Stream<String> lines = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            // resource is read line by line for larger files
            lines.forEach(line -> {
                try {
                    processLine(line, results);
                } catch (APIException e) {
                    // exception is wrapped to be able to throw within lambda
                    throw new RuntimeException(e.getMessage(), e);
                }
            });
        } catch (NoSuchFileException e) {
            throw new APIException("Input file does not exist", e);
        } catch (IOException e) {
            throw new APIException("Error while reading input file", e);
        } catch (NumberFormatException e) {
            throw new APIException("Error while parsing input file", e);
        } catch (RuntimeException e) {
            throw new APIException(e.getMessage(), e);
        }
        return String.join("\n", results);
    }

    private static void processLine(String line, List<String> results) throws APIException {
        // validate content before parsing
        PackageValidator.validateLine(line);

        // parse the given line of case
        Package pack = PackageParser.parse(line);

        // solve package item selection
        PackageResult packageResult = PackageSolver.solve(pack);

        // generate results for the case
        results.add(PackageParser.generateResultString(packageResult.getSelectedItems()));
    }

}
