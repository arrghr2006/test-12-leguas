package com.taller.vehiculosservice.utils;

import com.taller.vehiculosservice.model.dto.VehiculoDieselDTO;
import com.taller.vehiculosservice.model.dto.VehiculoDieselResponseDTO;
import com.taller.vehiculosservice.model.enumtypes.TipoBombaInyeccionEnum;
import com.taller.vehiculosservice.model.enumtypes.TipoVehiculoEnum;
import com.taller.vehiculosservice.model.persistencia.VehiculoDiesel;
import lombok.Data;

@Data
public class VehiculoDieselDTOUtil {

    public static VehiculoDieselResponseDTO toResponseDTO(VehiculoDiesel entity){
        VehiculoDieselResponseDTO dto = new VehiculoDieselResponseDTO();
        dto.setVin(entity.getVin());
        dto.setMatricula(entity.getMatricula());
        dto.setTipo(entity.getTipo().toString());
        dto.setId(entity.getId());
        dto.setTipoBombaInyeccion( entity.getTipoBombaInyeccion().toString());
        return dto;
    }

    public static VehiculoDiesel toEntity(VehiculoDieselDTO dto){
        VehiculoDiesel entity = new VehiculoDiesel();
        entity.setVin(dto.getVin());
        entity.setMatricula(dto.getMatricula());
        entity.setTipo(TipoVehiculoEnum.DIESEL);
        entity.setTipoBombaInyeccion( dto.getTipoBombaInyeccion()!=null ? TipoBombaInyeccionEnum.valueOf(dto.getTipoBombaInyeccion().trim().toUpperCase()) : null);

        return entity;
    }

    private VehiculoDieselDTOUtil(){
        throw new IllegalStateException("Utility class");
    }
}
