package com.taller.vehiculosservice.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Builder
@Data
@ToString
@AllArgsConstructor
public class MessageResponse {
    private String message;

    private Object object;

    private HttpStatus status;
}
