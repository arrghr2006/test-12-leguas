package com.taller.vehiculosservice.service;

import com.taller.vehiculosservice.exception.RequestException;
import com.taller.vehiculosservice.model.dto.VehiculoElectricoDTO;

import java.util.List;

public interface VehiculoElectricoServiceInterface {

    public List<VehiculoElectricoDTO> getAll();

    public VehiculoElectricoDTO getById(Integer id) throws RequestException;

    public VehiculoElectricoDTO create(VehiculoElectricoDTO dto) throws RequestException;

    public VehiculoElectricoDTO update(Integer id, VehiculoElectricoDTO dto) throws RequestException;

    public void delete(Integer id) throws RequestException;
}
