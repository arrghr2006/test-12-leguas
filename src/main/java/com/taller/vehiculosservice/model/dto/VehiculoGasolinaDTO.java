package com.taller.vehiculosservice.model.dto;

import com.taller.vehiculosservice.model.enumtypes.TipoVehiculoEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoGasolinaDTO extends VehiculoDTO{

    @NotBlank(message = "Debe especificar el tipo de gasolina del vehículo.")
    private String tiposGasolina;

    public VehiculoGasolinaDTO(String vid, String chapa, Boolean aReconvertir, TipoVehiculoEnum newTipo, String tipoGas){
        super( vid, chapa, TipoVehiculoEnum.GASOLINA.toString(), aReconvertir, newTipo.toString());
        this.setTiposGasolina(tipoGas);
    }
}
