package com.taller.vehiculosservice.exception;

import com.taller.vehiculosservice.model.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handlerMethodArgumentNotValidException(MethodArgumentNotValidException except, WebRequest request){
        Map<String, Object> mapErrors = new HashMap<>();

        except.getBindingResult().getAllErrors().forEach(
                error -> {
                    String key = ((FieldError)error).getField();
                    String value = error.getDefaultMessage();
                    mapErrors.put(key, value);
                }
        );
        return new ResponseEntity<>( ErrorDTO.builder().backendMessage(ErrorMessage.VALIDATION_PARAMS)
                                                       .message(mapErrors.toString())
                                                       .code("VALIDATION")
                                                       .status(HttpStatus.BAD_REQUEST).build(),
                                     HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RequestException.class)
    public ResponseEntity<ErrorDTO> handlerRequestException(RequestException except){
        HttpStatus estado;
        try {
            estado = HttpStatus.valueOf(except.getStatus());
        }catch (Exception ex ){
            estado = HttpStatus.BAD_REQUEST;
        }
        ErrorDTO error = new ErrorDTO( estado,
                                       except.getCode(), except.getBackendMessage(), except.getMessage());
        return new ResponseEntity<>( error, HttpStatus.valueOf(except.getStatus()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handlerGeneralException(Exception except){
        ErrorDTO error = new ErrorDTO( HttpStatus.BAD_REQUEST, ErrorCode.BAD_REQUEST, ErrorMessage.INTERNAL_ERROR, ErrorMessage.INTERNAL_ERROR);
        return new ResponseEntity<>( error, HttpStatus.BAD_REQUEST);
    }

}
