package com.taller.vehiculosservice.repository;

import com.taller.vehiculosservice.model.persistencia.VehiculoElectrico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoElectricoRepository extends JpaRepository<VehiculoElectrico, Integer> {

}
