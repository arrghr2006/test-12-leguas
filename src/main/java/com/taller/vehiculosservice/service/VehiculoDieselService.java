package com.taller.vehiculosservice.service;

import com.taller.vehiculosservice.exception.ErrorCode;
import com.taller.vehiculosservice.exception.ErrorMessage;
import com.taller.vehiculosservice.exception.RequestException;
import com.taller.vehiculosservice.model.dto.VehiculoDieselDTO;
import com.taller.vehiculosservice.model.dto.VehiculoDieselResponseDTO;
import com.taller.vehiculosservice.model.persistencia.Vehiculo;
import com.taller.vehiculosservice.model.persistencia.VehiculoDiesel;
import com.taller.vehiculosservice.repository.VehiculoDieselRepository;
import com.taller.vehiculosservice.repository.VehiculoRepository;
import com.taller.vehiculosservice.utils.VehiculoDieselDTOUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VehiculoDieselService implements VehiculoDieselServiceInterface {

    private final VehiculoDieselRepository vehiculoDieselRepository;
    private final VehiculoRepository vehiculoRepository;

    public List<VehiculoDieselResponseDTO> getAll(){
        return vehiculoDieselRepository.findAll().stream().map(VehiculoDieselDTOUtil::toResponseDTO).toList();
    }

    public VehiculoDieselResponseDTO getById(Integer id) throws RequestException {
        Optional<VehiculoDiesel> vehiculo = vehiculoDieselRepository.findById(id);
        if(vehiculo.isEmpty()) {
            throw new RequestException( ErrorCode.VEHICLE_NOT_FOUND, ErrorMessage.VEHICLE_NOT_FOUND,
                                        ErrorMessage.VEHICLE_NOT_FOUND, HttpStatus.NOT_FOUND.name());
        }
        return vehiculo.map(VehiculoDieselDTOUtil::toResponseDTO).get();
    }

    public VehiculoDieselResponseDTO create(VehiculoDieselDTO dto) throws RequestException {
        Optional<Vehiculo> entity = vehiculoRepository.findVehiculoByVinMatricula(dto.getVin(), dto.getMatricula());
        if(entity.isPresent()){
            throw new RequestException( ErrorCode.DUPLICATED_VEHICLE, ErrorMessage.DUPLICATED_VEHICLE,
                                        ErrorMessage.DUPLICATED_VEHICLE, HttpStatus.BAD_REQUEST.name());
        }
        if(dto.getReconvertir()!=null && dto.getReconvertir().equals(Boolean.TRUE)){
            throw new RequestException( ErrorCode.BAD_REQUEST, ErrorMessage.RECONVERSION_NO_PERMITIDA,
                                        ErrorMessage.RECONVERSION_NO_PERMITIDA, HttpStatus.BAD_REQUEST.name());
        }
        try {
            return VehiculoDieselDTOUtil.toResponseDTO(vehiculoDieselRepository.save(VehiculoDieselDTOUtil.toEntity(dto)));
        }catch (IllegalArgumentException exc){
            throw new RequestException( ErrorCode.BAD_REQUEST, ErrorMessage.VALIDATION_PARAMS,
                                        ErrorMessage.VALIDATION_PARAMS, HttpStatus.BAD_REQUEST.name());
        }
    }

    public VehiculoDieselResponseDTO update(Integer id, VehiculoDieselDTO dto) throws RequestException {
        Optional<VehiculoDiesel> entity = vehiculoDieselRepository.findById(id);
        if(entity.isEmpty()){
            throw new RequestException( ErrorCode.VEHICLE_NOT_FOUND, ErrorMessage.VEHICLE_NOT_FOUND,
                                        ErrorMessage.VEHICLE_NOT_FOUND, HttpStatus.NOT_FOUND.name());
        }
        if(dto.getReconvertir()!=null && dto.getReconvertir().equals(Boolean.TRUE)){
            throw new RequestException( ErrorCode.BAD_REQUEST, ErrorMessage.RECONVERSION_NO_PERMITIDA,
                    ErrorMessage.RECONVERSION_NO_PERMITIDA, HttpStatus.BAD_REQUEST.name());
        }
        try {
            VehiculoDiesel vehiculo = VehiculoDieselDTOUtil.toEntity(dto);
            vehiculo.setId(id);
            return VehiculoDieselDTOUtil.toResponseDTO(vehiculoDieselRepository.save(vehiculo));
        }catch (IllegalArgumentException exc){
            throw new RequestException( ErrorCode.BAD_REQUEST, ErrorMessage.VALIDATION_PARAMS,
                                        ErrorMessage.VALIDATION_PARAMS, HttpStatus.BAD_REQUEST.name());
        }
    }

    public void delete(Integer id) throws RequestException {
        Optional<VehiculoDiesel> entity = vehiculoDieselRepository.findById(id);
        if(entity.isEmpty()){
            throw new RequestException( ErrorCode.VEHICLE_NOT_FOUND, ErrorMessage.VEHICLE_NOT_FOUND,
                    ErrorMessage.VEHICLE_NOT_FOUND, HttpStatus.NOT_FOUND.name());
        }
        vehiculoDieselRepository.deleteById(id);
    }
}
