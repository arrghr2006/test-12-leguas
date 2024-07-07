package com.taller.vehiculosservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Builder
public class ErrorDTO {

            private HttpStatus status;

            private String code;

            private String backendMessage;

            private String message;
}
