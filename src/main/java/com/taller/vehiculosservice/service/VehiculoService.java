package com.taller.vehiculosservice.service;

import com.taller.vehiculosservice.exception.ErrorCode;
import com.taller.vehiculosservice.exception.ErrorMessage;
import com.taller.vehiculosservice.exception.RequestException;
import com.taller.vehiculosservice.model.dto.*;
import com.taller.vehiculosservice.model.enumtypes.TipoVehiculoEnum;
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

        Boolean reconvertir;
        String tipoReconvertido;

        if(listado!=null && !listado.isEmpty()){
            for(Object[] itemList :listado ){
                reconvertir = (Boolean)(itemList[1]);
                tipoReconvertido = itemList[2]!=null ? itemList[2].toString() : null;
                if(itemList[0].toString().equals(TipoVehiculoEnum.DIESEL.toString())){
                    resultadoList.add( new VehiculoDieselDTOOut(itemList[3].toString()));
                }
                else if(itemList[0].toString().equals(TipoVehiculoEnum.ELECTRICO.toString())){
                    if(reconvertir.equals(Boolean.TRUE) && tipoReconvertido!=null) {
                        resultadoList.add(new VehiculoElectricoReconvertirOutDTO(tipoReconvertido, itemList[3].toString()));
                    } else {
                        resultadoList.add(new VehiculoElectricoDTOOut(itemList[3].toString()));
                    }
                }
                else resultadoList.add(new VehiculoGasolinaDTOOut(itemList[3].toString()));
            }
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
