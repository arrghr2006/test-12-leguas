package com.taller.vehiculosservice.utils;

import com.taller.vehiculosservice.model.dto.VehiculoGasolinaDTO;
import com.taller.vehiculosservice.model.dto.VehiculoGasolinaResponseDTO;
import com.taller.vehiculosservice.model.enumtypes.TipoGasolinaEnum;
import com.taller.vehiculosservice.model.enumtypes.TipoVehiculoEnum;
import com.taller.vehiculosservice.model.persistencia.VehiculoGasolina;
import lombok.Data;

@Data
public class VehiculoGasolinaDTOUtil {

    public static VehiculoGasolinaResponseDTO toResponseDTO(VehiculoGasolina entity){
        VehiculoGasolinaResponseDTO dto = new VehiculoGasolinaResponseDTO();
        dto.setId(entity.getId());
        dto.setVin(entity.getVin());
        dto.setMatricula(entity.getMatricula());
        dto.setTipo(entity.getTipo().toString());
        dto.setTiposGasolina( entity.getTiposGasolina());
        return dto;
    }

    public static VehiculoGasolina toEntity(VehiculoGasolinaDTO dto){
        VehiculoGasolina entity = new VehiculoGasolina();
        entity.setVin(dto.getVin());
        entity.setMatricula(dto.getMatricula());
        entity.setTipo(TipoVehiculoEnum.GASOLINA);

        String tiposGasolinaIn = dto.getTiposGasolina()==null ? "" : dto.getTiposGasolina().toUpperCase();
        String tiposGasolinaOut = tiposGasolinaIn.contains(TipoGasolinaEnum.B83.toString()) ? TipoGasolinaEnum.B83.toString() : "";
        if(tiposGasolinaIn.contains(TipoGasolinaEnum.B90.toString())){
            tiposGasolinaOut = tiposGasolinaOut.concat(
                     tiposGasolinaOut.isEmpty() ? TipoGasolinaEnum.B90.toString() : " "+TipoGasolinaEnum.B90 );
        }
        if(tiposGasolinaIn.contains(TipoGasolinaEnum.B94.toString())){
            tiposGasolinaOut = tiposGasolinaOut.concat(
                    tiposGasolinaOut.isEmpty() ? TipoGasolinaEnum.B94.toString() : " "+TipoGasolinaEnum.B94 );
        }
        if(tiposGasolinaIn.contains(TipoGasolinaEnum.B100.toString())){
            tiposGasolinaOut = tiposGasolinaOut.concat(
                    tiposGasolinaOut.isEmpty() ? TipoGasolinaEnum.B100.toString() : " "+TipoGasolinaEnum.B100 );
        }

        entity.setTiposGasolina( tiposGasolinaOut.isEmpty() ? null : tiposGasolinaOut);

        return entity;
    }

    private VehiculoGasolinaDTOUtil(){
        throw new IllegalStateException("Utility class");
    }
}
