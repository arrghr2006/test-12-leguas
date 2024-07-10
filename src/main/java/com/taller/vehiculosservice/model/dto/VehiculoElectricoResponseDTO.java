package com.taller.vehiculosservice.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoElectricoResponseDTO extends VehiculoResponseDTO{

    private String tipoBateria;

    private Integer voltaje;

    private Integer corriente;

}
