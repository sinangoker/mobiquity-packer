package com.mobiquity.packer;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * The helper methods for Parameterized tests.
 */
public class PackerTestUtils {

    /**
     * The constant INPUT_FILE.
     */
    public static final String INPUT_FILE = "example_input";
    /**
     * The constant OUTPUT_FILE.
     */
    public static final String OUTPUT_FILE = "example_output";

    private PackerTestUtils() {
    }

    /**
     * Gets absolute path of the file.
     *
     * @param fileName the file name
     * @return the absolute path
     * @throws URISyntaxException the urı syntax exception
     */
    public static String getAbsolutePath(String fileName) throws URISyntaxException {
        URI inputFileUri = PackerTestUtils.getResourcePath(fileName);
        File file = new File(inputFileUri);
        return file.getAbsolutePath();
    }

    /**
     * Gets URI of the file.
     *
     * @param fileName the file name
     * @return the resource path
     * @throws URISyntaxException the urı syntax exception
     */
    public static URI getResourcePath(String fileName) throws URISyntaxException {
        return PackerTestUtils.class.getClassLoader().getResource(fileName).toURI();
    }

    /**
     * Returns Stream for given fileName under resource path.
     *
     * @param fileName the file name
     * @return the Stream
     * @throws URISyntaxException the uri syntax exception
     * @throws IOException        the io exception
     */
    public static Stream<String> getFileStream(String fileName) throws URISyntaxException, IOException {
        return Files.lines(Paths.get(getResourcePath(fileName)));
    }

    /**
     * Read content of the file.
     *
     * @param fileName the file name
     * @return the string
     * @throws IOException        the io exception
     * @throws URISyntaxException the uri syntax exception
     */
    public static String readFile(String fileName) throws URISyntaxException, IOException {
        return Files.readString(Paths.get(getResourcePath(fileName)), StandardCharsets.UTF_8);
    }
}