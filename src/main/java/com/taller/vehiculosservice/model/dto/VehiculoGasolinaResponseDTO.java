package com.taller.vehiculosservice.model.dto;

import com.taller.vehiculosservice.model.enumtypes.TipoVehiculoEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoGasolinaResponseDTO extends VehiculoResponseDTO{

    private String tiposGasolina;

    public VehiculoGasolinaResponseDTO(Integer aId, String vid, String chapa,
                                       Boolean aReconvertir, TipoVehiculoEnum newTipo,
                                       String tipoGas){
        super( aId, vid, chapa, TipoVehiculoEnum.GASOLINA.toString(), aReconvertir, newTipo.toString());
        this.setTiposGasolina(tipoGas);
    }
}
