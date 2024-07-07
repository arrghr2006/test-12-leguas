package com.taller.vehiculosservice.service;

import com.taller.vehiculosservice.exception.RequestException;
import com.taller.vehiculosservice.model.dto.VehiculoGasolinaDTO;

import java.util.List;

public interface VehiculoGasolinaServiceInterface {

    public List<VehiculoGasolinaDTO> getAll();

    public VehiculoGasolinaDTO getById(Integer id) throws RequestException;

    public VehiculoGasolinaDTO create(VehiculoGasolinaDTO dto) throws RequestException;

    public VehiculoGasolinaDTO update(Integer id, VehiculoGasolinaDTO dto) throws RequestException;

    public void delete(Integer id) throws RequestException;
}
