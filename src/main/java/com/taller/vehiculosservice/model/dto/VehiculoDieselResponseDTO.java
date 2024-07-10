package com.taller.vehiculosservice.model.dto;

import com.taller.vehiculosservice.model.enumtypes.TipoVehiculoEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDieselResponseDTO extends VehiculoResponseDTO{

    private String tipoBombaInyeccion;

    public VehiculoDieselResponseDTO( Integer aId, String vid, String chapa, Boolean aReconvertir, String newTipo, String tipoBomba){
        super( aId, vid, chapa, TipoVehiculoEnum.DIESEL.toString(), aReconvertir, newTipo);
        this.setTipoBombaInyeccion(tipoBomba);
    }
}
