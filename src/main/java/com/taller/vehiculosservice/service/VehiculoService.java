package com.taller.vehiculosservice.service;

import com.taller.vehiculosservice.exception.ErrorCode;
import com.taller.vehiculosservice.exception.ErrorMessage;
import com.taller.vehiculosservice.exception.RequestException;
import com.taller.vehiculosservice.model.dto.*;
import com.taller.vehiculosservice.model.persistencia.Vehiculo;
import com.taller.vehiculosservice.repository.VehiculoRepository;
import com.taller.vehiculosservice.utils.VehiculoDTOUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VehiculoService implements VehiculoServiceInterface {

    private final VehiculoRepository vehiculoRepository;

    public List<VehiculoDTOOut> getAll(){
        List<Object[]> listado = vehiculoRepository.listarTodos();
        List<VehiculoDTOOut> resultadoList = new ArrayList<>();

        if(listado!=null && !listado.isEmpty()){
            listado.forEach(
                    array -> {
                        switch (array[0].toString()) {
                            case "DIESEL" -> resultadoList.add( new VehiculoDieselDTOOut(array[3].toString()));
                            case "GASOLINA" -> resultadoList.add(new VehiculoGasolinaDTOOut(array[3].toString()));
                            case "ELECTRICO" ->resultadoList.add( ((array[1]).equals(Boolean.TRUE) && array[2]!=null)
                                                                    ? new VehiculoElectricoReconvertirOutDTO(array[2].toString(), array[3].toString())
                                                                    : new VehiculoElectricoDTOOut(array[3].toString()) );
                            default -> throw new RequestException( ErrorCode.NO_VALID_DATA, ErrorMessage.NO_VALID_DATA,
                                                                   ErrorMessage.NO_VALID_DATA, HttpStatus.INTERNAL_SERVER_ERROR.name());
                        }
                    }
            );
        }
        return resultadoList;
    }

    public VehiculoDTO getById(Integer id) throws RequestException {
        Optional<Vehiculo> inventory = vehiculoRepository.findById(id);
        if(inventory.isEmpty()) {
            throw new RequestException( ErrorCode.VEHICLE_NOT_FOUND, ErrorMessage.VEHICLE_NOT_FOUND,
                                        ErrorMessage.VEHICLE_NOT_FOUND, HttpStatus.NOT_FOUND.name());
        }
        return inventory.map(VehiculoDTOUtil::toDTO).get();
    }

}
