package com.taller.vehiculosservice.utils;

import com.taller.vehiculosservice.model.dto.VehiculoElectricoDTO;
import com.taller.vehiculosservice.model.dto.VehiculoElectricoResponseDTO;
import com.taller.vehiculosservice.model.enumtypes.TipoBateriaEnum;
import com.taller.vehiculosservice.model.enumtypes.TipoVehiculoEnum;
import com.taller.vehiculosservice.model.persistencia.VehiculoElectrico;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehiculoElectricoDTOUtil {

    public static VehiculoElectricoResponseDTO toResponseDTO(VehiculoElectrico entity){
        VehiculoElectricoResponseDTO dto = new VehiculoElectricoResponseDTO();
        dto.setId(entity.getId());
        dto.setVin(entity.getVin());
        dto.setMatricula(entity.getMatricula());
        dto.setTipo(entity.getTipo().toString());
        dto.setCorriente(entity.getCorriente());
        dto.setVoltaje(entity.getVoltaje());
        dto.setTipoBateria(entity.getTipoBateria().toString());
        dto.setReconvertir(entity.getReconvertir());
        dto.setTipoReconvertido( entity.getTipoReconvertido()!=null ? entity.getTipoReconvertido().toString() : null);
        return dto;
    }

    public static VehiculoElectrico toEntity(VehiculoElectricoDTO dto){
        VehiculoElectrico entity = new VehiculoElectrico();
        entity.setVin(dto.getVin());
        entity.setMatricula(dto.getMatricula());
        entity.setTipo(TipoVehiculoEnum.ELECTRICO);
        entity.setCorriente(dto.getCorriente());
        entity.setVoltaje(dto.getVoltaje());
        entity.setTipoBateria(TipoBateriaEnum.valueOf(dto.getTipoBateria().trim().toUpperCase()));
        entity.setReconvertir(dto.getReconvertir()!=null ? dto.getReconvertir() : Boolean.FALSE);
        entity.setTipoReconvertido( dto.getTipoReconvertido()!=null ? TipoVehiculoEnum.valueOf(dto.getTipoReconvertido().trim().toUpperCase()) : null);

        return entity;
    }

    private VehiculoElectricoDTOUtil(){
        throw new IllegalStateException("Utility class");
    }
}
