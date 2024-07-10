package com.taller.vehiculosservice.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTO {
    @NotBlank(message = "El número de identificación del vehículo no puede ser nulo")
    private String vin;

    @NotBlank(message = "La matrícula del vehículo no puede ser nulo")
    private String matricula;

    private String tipo;

    private Boolean reconvertir;

    private String tipoReconvertido;
}
