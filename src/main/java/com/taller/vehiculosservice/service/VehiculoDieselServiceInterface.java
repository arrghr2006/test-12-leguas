package com.taller.vehiculosservice.service;

import com.taller.vehiculosservice.exception.RequestException;
import com.taller.vehiculosservice.model.dto.VehiculoDieselDTO;
import com.taller.vehiculosservice.model.dto.VehiculoDieselResponseDTO;

import java.util.List;

public interface VehiculoDieselServiceInterface {

    List<VehiculoDieselResponseDTO> getAll();

    VehiculoDieselResponseDTO getById(Integer id) throws RequestException;

    VehiculoDieselResponseDTO create(VehiculoDieselDTO dto) throws RequestException;

    VehiculoDieselResponseDTO update(Integer id, VehiculoDieselDTO dto) throws RequestException;

    void delete(Integer id) throws RequestException;
}
