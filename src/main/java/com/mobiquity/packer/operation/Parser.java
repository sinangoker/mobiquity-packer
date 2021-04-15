package com.mobiquity.packer.operation;

import com.mobiquity.exception.APIException;
import com.mobiquity.packer.model.Package;

/**
 * The interface Package command.
 */
public interface Parser {

    /**
     * Parse operations.
     */
    Package parse(String packageString) throws APIException, NumberFormatException;

}