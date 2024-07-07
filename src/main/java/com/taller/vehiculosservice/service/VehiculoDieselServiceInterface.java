package com.taller.vehiculosservice.service;

import com.taller.vehiculosservice.exception.RequestException;
import com.taller.vehiculosservice.model.dto.VehiculoDieselDTO;

import java.util.List;

public interface VehiculoDieselServiceInterface {

    public List<VehiculoDieselDTO> getAll();

    public VehiculoDieselDTO getById(Integer id) throws RequestException;

    public VehiculoDieselDTO create(VehiculoDieselDTO dto) throws RequestException;

    public VehiculoDieselDTO update(Integer id, VehiculoDieselDTO dto) throws RequestException;

    public void delete(Integer id) throws RequestException;
}
