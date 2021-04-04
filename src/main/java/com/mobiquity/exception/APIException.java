package com.mobiquity.exception;

/**
 * The APIException is created for wrapping packer exceptions.
 */
public class APIException extends Exception {

    /**
     * Instantiates a new Api exception.
     *
     * @param message the message
     * @param e       the exception
     */
    public APIException(String message, Exception e) {
    super(message, e);
  }

    /**
     * Instantiates a new Api exception.
     *
     * @param message the message
     */
    public APIException(String message) {
    super(message);
  }
}
