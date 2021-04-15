package com.mobiquity.packer;

import com.mobiquity.exception.APIException;

public interface Packer {

    String pack(String filePath) throws APIException;
}