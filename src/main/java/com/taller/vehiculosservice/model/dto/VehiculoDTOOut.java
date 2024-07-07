package com.taller.vehiculosservice.model.dto;

import com.taller.vehiculosservice.model.enumtypes.TipoVehiculoEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class VehiculoDTOOut {

    private TipoVehiculoEnum tipo;

    protected VehiculoDTOOut(String info){
        super();
        construyeDesdeString(info);
    }

    protected abstract void construyeDesdeString(String info);
}
