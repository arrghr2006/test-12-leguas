package com.taller.vehiculosservice.model.dto;

import com.taller.vehiculosservice.model.enumtypes.TipoVehiculoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoElectricoDTO extends VehiculoDTO{
    @NotBlank(message = "Debe especificar el tipo de batería del vehículo")
    private String tipoBateria;

    @NotNull(message = "Debe especificar el voltaje de la batería del vehículo")
    @Range(min = 100, max = 300, message = "El voltaje debe ser un entero entre 100 y 300 voltios.")
    private Integer voltaje;

    @NotNull(message = "Debe especificar la corriente de la batería del vehículo")
    @Range(min = 10, max = 20, message = "La corriente debe ser un entero entre 10 y 20 amperes.")
    private Integer corriente;

    public VehiculoElectricoDTO(String vid, String chapa, Boolean aReconvertir, TipoVehiculoEnum newTipo,
                                String tipoBateria, Integer voltBat, Integer corrienteBateria ){
        super( vid, chapa, TipoVehiculoEnum.ELECTRICO.toString(), aReconvertir, newTipo!=null ? newTipo.toString() : null);
        this.setTipoBateria(tipoBateria);
        this.setVoltaje(voltBat);
        this.setCorriente(corrienteBateria);
    }
}
