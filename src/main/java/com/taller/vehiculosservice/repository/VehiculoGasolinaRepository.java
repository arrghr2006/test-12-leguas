package com.taller.vehiculosservice.repository;

import com.taller.vehiculosservice.model.persistencia.VehiculoGasolina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoGasolinaRepository extends JpaRepository<VehiculoGasolina, Integer> {

}
