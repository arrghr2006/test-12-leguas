package com.taller.vehiculosservice.service;

import com.taller.vehiculosservice.exception.ErrorCode;
import com.taller.vehiculosservice.exception.ErrorMessage;
import com.taller.vehiculosservice.exception.RequestException;
import com.taller.vehiculosservice.model.dto.VehiculoElectricoDTO;
import com.taller.vehiculosservice.model.dto.VehiculoElectricoResponseDTO;
import com.taller.vehiculosservice.model.persistencia.Vehiculo;
import com.taller.vehiculosservice.model.persistencia.VehiculoElectrico;
import com.taller.vehiculosservice.repository.VehiculoElectricoRepository;
import com.taller.vehiculosservice.repository.VehiculoRepository;
import com.taller.vehiculosservice.utils.VehiculoElectricoDTOUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VehiculoElectricoService implements VehiculoElectricoServiceInterface {

    private final VehiculoElectricoRepository vehiculoElectricoRepository;
    private final VehiculoRepository vehiculoRepository;

    public List<VehiculoElectricoResponseDTO> getAll(){
        return vehiculoElectricoRepository.findAll().stream().map(VehiculoElectricoDTOUtil::toResponseDTO).toList();
    }

    public VehiculoElectricoResponseDTO getById(Integer id) throws RequestException {
        Optional<VehiculoElectrico> vehiculo = vehiculoElectricoRepository.findById(id);
        if(vehiculo.isEmpty()) {
            throw new RequestException( ErrorCode.VEHICLE_NOT_FOUND, ErrorMessage.VEHICLE_NOT_FOUND,
                                        ErrorMessage.VEHICLE_NOT_FOUND, HttpStatus.NOT_FOUND.name());
        }
        return vehiculo.map(VehiculoElectricoDTOUtil::toResponseDTO).get();
    }

    private Boolean getReconversionValida(VehiculoElectricoDTO dto){
        return dto.getReconvertir()==null || Boolean.FALSE.equals(dto.getReconvertir())
                    ? Boolean.TRUE
                    : dto.getTipoReconvertido()!=null && !dto.getTipoReconvertido().isEmpty();
    }

    public VehiculoElectricoResponseDTO create(VehiculoElectricoDTO dto) throws RequestException {
        Optional<Vehiculo> entity = vehiculoRepository.findVehiculoByVinMatricula(dto.getVin(), dto.getMatricula());
        if(entity.isPresent()){
            throw new RequestException( ErrorCode.DUPLICATED_VEHICLE, ErrorMessage.DUPLICATED_VEHICLE,
                                        ErrorMessage.DUPLICATED_VEHICLE, HttpStatus.BAD_REQUEST.name());
        }

        if(Boolean.FALSE.equals(this.getReconversionValida(dto))){
            throw new RequestException( ErrorCode.BAD_REQUEST, ErrorMessage.RECONVERSION_ERROR,
                                        ErrorMessage.RECONVERSION_ERROR, HttpStatus.BAD_REQUEST.name());
        }
        try {
            return VehiculoElectricoDTOUtil.toResponseDTO(vehiculoElectricoRepository.save(VehiculoElectricoDTOUtil.toEntity(dto)));
        }catch (IllegalArgumentException exc){
            throw new RequestException( ErrorCode.BAD_REQUEST, ErrorMessage.VALIDATION_PARAMS,
                                        ErrorMessage.VALIDATION_PARAMS, HttpStatus.BAD_REQUEST.name());
        }
    }

    public VehiculoElectricoResponseDTO update(Integer id, VehiculoElectricoDTO dto) throws RequestException {
        Optional<VehiculoElectrico> entity = vehiculoElectricoRepository.findById(id);
        if(entity.isEmpty()){
            throw new RequestException( ErrorCode.VEHICLE_NOT_FOUND, ErrorMessage.VEHICLE_NOT_FOUND,
                                        ErrorMessage.VEHICLE_NOT_FOUND, HttpStatus.NOT_FOUND.name());
        }
        if(Boolean.FALSE.equals(this.getReconversionValida(dto))) {
            throw new RequestException( ErrorCode.BAD_REQUEST, ErrorMessage.RECONVERSION_ERROR,
                                        ErrorMessage.RECONVERSION_ERROR, HttpStatus.BAD_REQUEST.name());
        }
        try {
            VehiculoElectrico vehiculo = VehiculoElectricoDTOUtil.toEntity(dto);
            vehiculo.setId(id);
            return VehiculoElectricoDTOUtil.toResponseDTO(vehiculoElectricoRepository.save(vehiculo));
        }catch (IllegalArgumentException exc){
            throw new RequestException( ErrorCode.BAD_REQUEST, ErrorMessage.VALIDATION_PARAMS,
                    ErrorMessage.VALIDATION_PARAMS, HttpStatus.BAD_REQUEST.name());
        }
    }

    public void delete(Integer id) throws RequestException {
        Optional<VehiculoElectrico> entity = vehiculoElectricoRepository.findById(id);
        if(entity.isEmpty()){
            throw new RequestException( ErrorCode.VEHICLE_NOT_FOUND, ErrorMessage.VEHICLE_NOT_FOUND,
                                        ErrorMessage.VEHICLE_NOT_FOUND, HttpStatus.NOT_FOUND.name());
        }
        vehiculoElectricoRepository.deleteById(id);
    }
}
