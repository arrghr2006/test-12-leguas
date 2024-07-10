package com.taller.vehiculosservice.model.dto;

import com.taller.vehiculosservice.model.enumtypes.TipoVehiculoEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoElectricoResponseDTO extends VehiculoResponseDTO{

    private String tipoBateria;

    private Integer voltaje;

    private Integer corriente;

    public VehiculoElectricoResponseDTO( Integer aId, String vid, String chapa, Boolean aReconvertir,
                                         TipoVehiculoEnum newTipo, String tipoBateria,
                                         Integer voltBat, Integer corrienteBateria ){
        super( aId, vid, chapa, TipoVehiculoEnum.ELECTRICO.toString(), aReconvertir, newTipo!=null ? newTipo.toString() : null);
        this.setTipoBateria(tipoBateria);
        this.setVoltaje(voltBat);
        this.setCorriente(corrienteBateria);
    }
}
