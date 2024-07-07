package com.taller.vehiculosservice.integrationTest.repositories;

import com.taller.vehiculosservice.model.persistencia.Vehiculo;
import com.taller.vehiculosservice.repository.VehiculoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class VehiculoRepositoryIntegrationTest {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Test
    @DisplayName("Encontrando vehiculo por Vin o Matricula")
    void should_find_an_Vehiculo_by_vin_matricula() {
        Optional<Vehiculo> vehiculo = this.vehiculoRepository.findVehiculoByVin("1111");

        assertTrue(vehiculo.isPresent());
        assertEquals("B73046", vehiculo.get().getMatricula());
    }

    @Test
    @DisplayName("No debe encontrar un vehiculo por Matricula que no existe")
    void should_not_find_an_Vehiculo_by_vin_that_does_not_exist() {
        Optional<Vehiculo> vehiculo = this.vehiculoRepository.findVehiculoByMatricula("Z98872");

        assertTrue(vehiculo.isEmpty());
    }

}