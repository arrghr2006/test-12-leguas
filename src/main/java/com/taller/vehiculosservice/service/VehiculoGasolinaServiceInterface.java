package com.taller.vehiculosservice.service;

import com.taller.vehiculosservice.exception.RequestException;
import com.taller.vehiculosservice.model.dto.VehiculoGasolinaDTO;
import com.taller.vehiculosservice.model.dto.VehiculoGasolinaResponseDTO;

import java.util.List;

public interface VehiculoGasolinaServiceInterface {

    List<VehiculoGasolinaResponseDTO> getAll();

    VehiculoGasolinaResponseDTO getById(Integer id) throws RequestException;

    VehiculoGasolinaResponseDTO create(VehiculoGasolinaDTO dto) throws RequestException;

    VehiculoGasolinaResponseDTO update(Integer id, VehiculoGasolinaDTO dto) throws RequestException;

    void delete(Integer id) throws RequestException;
}
