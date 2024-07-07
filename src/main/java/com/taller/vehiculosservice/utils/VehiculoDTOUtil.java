package com.taller.vehiculosservice.utils;

import com.taller.vehiculosservice.model.dto.VehiculoDTO;
import com.taller.vehiculosservice.model.persistencia.Vehiculo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class VehiculoDTOUtil {

    public static String toString(Object[] info){
        return (info!=null && info.length>0) ? info[0].toString(): "";
    }

    public static VehiculoDTO toDTO(Vehiculo entity){
        VehiculoDTO dto = new VehiculoDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    private VehiculoDTOUtil(){
        throw new IllegalStateException("Utility class");
    }
}
