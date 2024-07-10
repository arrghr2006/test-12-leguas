package com.taller.vehiculosservice.model.dto;

import com.taller.vehiculosservice.model.enumtypes.TipoVehiculoEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDieselDTO extends VehiculoDTO{

    @NotBlank(message = "El tipo de bomba de inyección no puede ser nulo")
    private String tipoBombaInyeccion;

    public VehiculoDieselDTO(String vid, String chapa, Boolean aReconvertir, String newTipo, String tipoBomba){
        super( vid, chapa, TipoVehiculoEnum.DIESEL.toString(), aReconvertir, newTipo);
        this.setTipoBombaInyeccion(tipoBomba);
    }
}
