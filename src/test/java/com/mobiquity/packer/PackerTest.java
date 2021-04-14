package com.mobiquity.packer;


import com.mobiquity.exception.APIException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Packer operation tests.
 */
class PackerTest {

    /**
     * Checks input and output resources.
     */
    @Test
    void checkResources() {
        try {
            Stream<String> inputSource = PackerTestUtils.getFileStream(PackerTestUtils.INPUT_FILE);
            assertNotNull(inputSource);
            Stream<String> outputSource = PackerTestUtils.getFileStream(PackerTestUtils.OUTPUT_FILE);
            assertNotNull(outputSource);
        } catch (IOException e) {
            fail("Error while checking resources: IO Operations");
        } catch (URISyntaxException e) {
            fail("Error while checking resources: URISyntax");
        }

    }

    /**
     * Checks Packer pack function.
     */
    @Test
    void pack() {
        try {
            String inputFilePath = PackerTestUtils.getAbsolutePath(PackerTestUtils.INPUT_FILE);
            String output = PackerTestUtils.readFile(PackerTestUtils.OUTPUT_FILE);
            String result = Packer.pack(inputFilePath);

            assertEquals(result, output);
        } catch (APIException e) {
            fail("API error : " + e.getMessage());
        } catch (URISyntaxException e) {
            fail("InputFile url is not valid, error while packing input or output file");
        } catch (IOException e) {
            fail("URISyntax error while reading output file");
        }
    }
}