package com.taller.vehiculosservice.service;

import com.taller.vehiculosservice.exception.ErrorCode;
import com.taller.vehiculosservice.exception.ErrorMessage;
import com.taller.vehiculosservice.exception.RequestException;
import com.taller.vehiculosservice.model.dto.VehiculoGasolinaDTO;
import com.taller.vehiculosservice.model.persistencia.Vehiculo;
import com.taller.vehiculosservice.model.persistencia.VehiculoElectrico;
import com.taller.vehiculosservice.model.persistencia.VehiculoGasolina;
import com.taller.vehiculosservice.repository.VehiculoGasolinaRepository;
import com.taller.vehiculosservice.repository.VehiculoRepository;
import com.taller.vehiculosservice.utils.VehiculoElectricoDTOUtil;
import com.taller.vehiculosservice.utils.VehiculoGasolinaDTOUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VehiculoGasolinaService implements VehiculoGasolinaServiceInterface {

    private final VehiculoGasolinaRepository vehiculoGasolinaRepository;
    private final VehiculoRepository vehiculoRepository;

    public List<VehiculoGasolinaDTO> getAll(){
        return vehiculoGasolinaRepository.findAll().stream().map(VehiculoGasolinaDTOUtil::toDTO).toList();
    }

    public VehiculoGasolinaDTO getById(Integer id) throws RequestException {
        Optional<VehiculoGasolina> inventory = vehiculoGasolinaRepository.findById(id);
        if(inventory.isEmpty()) {
            throw new RequestException( ErrorCode.VEHICLE_NOT_FOUND, ErrorMessage.VEHICLE_NOT_FOUND,
                                        ErrorMessage.VEHICLE_NOT_FOUND, HttpStatus.NOT_FOUND.name());
        }
        return inventory.map(VehiculoGasolinaDTOUtil::toDTO).get();
    }

    public VehiculoGasolinaDTO create(VehiculoGasolinaDTO dto) throws RequestException {
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
            return VehiculoGasolinaDTOUtil.toDTO(vehiculoGasolinaRepository.save(VehiculoGasolinaDTOUtil.toEntity(dto)));
        }catch (DataIntegrityViolationException exc){
            throw new RequestException( ErrorCode.BAD_REQUEST, ErrorMessage.VALIDATION_PARAMS,
                                        ErrorMessage.VALIDATION_PARAMS, HttpStatus.BAD_REQUEST.name());
        }
    }

    public VehiculoGasolinaDTO update(Integer id, VehiculoGasolinaDTO dto) throws RequestException {
        Optional<VehiculoGasolina> entity = vehiculoGasolinaRepository.findById(id);
        if(entity.isEmpty()){
            throw new RequestException( ErrorCode.VEHICLE_NOT_FOUND, ErrorMessage.VEHICLE_NOT_FOUND,
                                        ErrorMessage.VEHICLE_NOT_FOUND, HttpStatus.NOT_FOUND.name());
        }
        if(dto.getReconvertir()!=null && dto.getReconvertir().equals(Boolean.TRUE)){
            throw new RequestException( ErrorCode.BAD_REQUEST, ErrorMessage.RECONVERSION_NO_PERMITIDA,
                    ErrorMessage.RECONVERSION_NO_PERMITIDA, HttpStatus.BAD_REQUEST.name());
        }
        try {
            VehiculoGasolina vehiculo = VehiculoGasolinaDTOUtil.toEntity(dto);
            vehiculo.setId(id);
            return VehiculoGasolinaDTOUtil.toDTO(vehiculoGasolinaRepository.save(vehiculo));
        }catch (DataIntegrityViolationException exc){
            throw new RequestException( ErrorCode.BAD_REQUEST, ErrorMessage.VALIDATION_PARAMS,
                                        ErrorMessage.VALIDATION_PARAMS, HttpStatus.BAD_REQUEST.name());
        }
    }

    public void delete(Integer id) throws RequestException {
        Optional<VehiculoGasolina> entity = vehiculoGasolinaRepository.findById(id);
        if(!entity.isEmpty()){
            throw new RequestException( ErrorCode.VEHICLE_NOT_FOUND, ErrorMessage.VEHICLE_NOT_FOUND,
                                        ErrorMessage.VEHICLE_NOT_FOUND, HttpStatus.NOT_FOUND.name());
        }
        vehiculoGasolinaRepository.deleteById(id);
    }
}
