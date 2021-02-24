package com.nextinno.unittest.trythrow;

public class ServiceException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 3604674541302892101L;
    public String message;
    public int errorCode;

    protected ServiceException(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public static ServiceException of(String message, int errorCode) {
        return new ServiceException(message, errorCode);
    }
}
