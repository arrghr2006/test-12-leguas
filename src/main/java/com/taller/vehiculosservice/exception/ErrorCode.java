package com.taller.vehiculosservice.exception;

public class ErrorCode {
    public static final String INTEGRITY_VIOLATION = "I-01";
    public static final String VEHICLE_NOT_FOUND = "I-02";
    public static final String BAD_REQUEST = "I-03";
    public static final String DUPLICATED_VEHICLE = "I-04";
    public static final String RECONVERSION_NO_PERMITIDA = "I-05";

    private ErrorCode(){
        throw new IllegalStateException("Utility class");
    }
}
