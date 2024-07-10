package com.taller.vehiculosservice.service;

import com.taller.vehiculosservice.exception.RequestException;
import com.taller.vehiculosservice.model.dto.VehiculoElectricoDTO;
import com.taller.vehiculosservice.model.dto.VehiculoElectricoResponseDTO;

import java.util.List;

public interface VehiculoElectricoServiceInterface {

    List<VehiculoElectricoResponseDTO> getAll();

    VehiculoElectricoResponseDTO getById(Integer id) throws RequestException;

    VehiculoElectricoResponseDTO create(VehiculoElectricoDTO dto) throws RequestException;

    VehiculoElectricoResponseDTO update(Integer id, VehiculoElectricoDTO dto) throws RequestException;

    void delete(Integer id) throws RequestException;
}
