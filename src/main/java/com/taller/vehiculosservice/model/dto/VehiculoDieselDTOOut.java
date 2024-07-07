package com.taller.vehiculosservice.model.dto;

import com.taller.vehiculosservice.model.enumtypes.TipoBombaInyeccionEnum;
import com.taller.vehiculosservice.model.enumtypes.TipoVehiculoEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class VehiculoDieselDTOOut extends VehiculoDTOOut{

    private String matricula;

    private TipoBombaInyeccionEnum tipoBombaInyeccion;

    public VehiculoDieselDTOOut(String info){
        super(info);
    }

    @Override
    protected void construyeDesdeString(String info){
        setTipo(TipoVehiculoEnum.DIESEL);
        if(info!=null && !info.isEmpty()){
            String[] infoSplitted = info.split(",");
            if(infoSplitted.length==2){
                setMatricula(infoSplitted[0]);
                setTipoBombaInyeccion(TipoBombaInyeccionEnum.valueOf(infoSplitted[1]));
            }
        }
    }
}
