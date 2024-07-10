package com.taller.vehiculosservice.model.dto;

import com.taller.vehiculosservice.model.enumtypes.TipoVehiculoEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoGasolinaDTOOut extends VehiculoDTOOut {

    private String matricula;

    private String tiposGasolina;

    public VehiculoGasolinaDTOOut(String info){
        super(info);
    }
    @Override
    protected void construyeDesdeString(String info){
        setTipo(TipoVehiculoEnum.GASOLINA);
        if(info!=null && !info.isEmpty()){
            String[] infoSplitted = info.split(",");
            if(infoSplitted.length==2){
                setMatricula(infoSplitted[0]);
                setTiposGasolina(infoSplitted[1]);
            }
        }
    }
}
