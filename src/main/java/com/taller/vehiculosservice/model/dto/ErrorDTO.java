package com.taller.vehiculosservice.model.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ErrorDTO {

            private HttpStatus status;

            private String code;

            private String backendMessage;

            private String message;
}
