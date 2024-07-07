package com.taller.vehiculosservice.integrationTest.repositories;

import com.taller.vehiculosservice.model.enumtypes.TipoBombaInyeccionEnum;
import com.taller.vehiculosservice.model.persistencia.VehiculoDiesel;
import com.taller.vehiculosservice.repository.VehiculoDieselRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class VehiculoDieselRepositoryIntegrationTest {
    @Autowired
    private VehiculoDieselRepository vehiculoRepository;

    @Test
    @DisplayName("Debe crear un nuevo auto diesel")
    void should_save_a_vehicle() {
        VehiculoDiesel auto = new VehiculoDiesel("99898", "TESTADD", false, null, TipoBombaInyeccionEnum.LINEAL);

        VehiculoDiesel autoDB = this.vehiculoRepository.save(auto);

        assertNotNull(autoDB.getId());
        assertEquals(auto.getVin(), autoDB.getVin());
        assertEquals(auto.getMatricula(), autoDB.getMatricula());
    }

    @Test
    @DisplayName("Debe modificar un auto diesel")
    void should_update_a_vehicle() {
        VehiculoDiesel auto = new VehiculoDiesel("99888", "TESTADD2", false, null, TipoBombaInyeccionEnum.LINEAL);

        VehiculoDiesel autoDB = this.vehiculoRepository.save(auto);

        assertNotNull(autoDB.getId());
        assertEquals(auto.getVin(), autoDB.getVin());
        assertEquals(auto.getMatricula(), autoDB.getMatricula());

        autoDB.setVin("77777");
        autoDB.setMatricula("TESTUPD");

        VehiculoDiesel autoUpdated = this.vehiculoRepository.save(autoDB);

        assertEquals(autoDB.getId(), autoUpdated.getId());
        assertEquals(autoDB.getVin(), autoUpdated.getVin());
        assertEquals(autoDB.getMatricula(), autoUpdated.getMatricula());
    }

}