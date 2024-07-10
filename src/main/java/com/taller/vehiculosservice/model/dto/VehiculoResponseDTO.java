package com.taller.vehiculosservice.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoResponseDTO {

    private Integer id;

    private String vin;

    private String matricula;

    private String tipo;

    private Boolean reconvertir = false;

    private String tipoReconvertido;
}
