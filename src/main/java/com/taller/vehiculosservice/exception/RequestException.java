package com.taller.vehiculosservice.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class RequestException extends RuntimeException {

    // Lo declare como String porque da bateo cuando le pongo HttpStatus, hay que reconstruirlo con
    // HttpStatus.valueOf para usarlo antes de dar una Response.
    private final String status;

    private final String code;

    private final String backendMessage;

    private final String message;

    public RequestException(String errorCode, String msg, String backMsg, String estado){
        super(msg);
        this.code = errorCode;
        this.message = msg;
        this.backendMessage = backMsg;
        this.status = estado;
    }
}
