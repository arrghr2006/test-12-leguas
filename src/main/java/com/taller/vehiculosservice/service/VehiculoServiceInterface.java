package com.taller.vehiculosservice.service;

import com.taller.vehiculosservice.exception.RequestException;
import com.taller.vehiculosservice.model.dto.VehiculoDTO;
import com.taller.vehiculosservice.model.dto.VehiculoDTOOut;

import java.util.List;

public interface VehiculoServiceInterface {

    public List<VehiculoDTOOut> getAll();

    public VehiculoDTO getById(Integer id) throws RequestException;

}
