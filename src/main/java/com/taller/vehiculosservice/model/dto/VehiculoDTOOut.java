package com.taller.vehiculosservice.model.dto;

import com.taller.vehiculosservice.model.enumtypes.TipoVehiculoEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class VehiculoDTOOut {

    private TipoVehiculoEnum tipo;

    protected VehiculoDTOOut(String info){
        super();
        construyeDesdeString(info);
    }

    protected abstract void construyeDesdeString(String info);
}
