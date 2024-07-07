package com.taller.vehiculosservice.data;

import com.taller.vehiculosservice.model.enumtypes.TipoBateriaEnum;
import com.taller.vehiculosservice.model.enumtypes.TipoBombaInyeccionEnum;
import com.taller.vehiculosservice.model.persistencia.VehiculoDiesel;
import com.taller.vehiculosservice.model.persistencia.VehiculoElectrico;
import com.taller.vehiculosservice.model.persistencia.VehiculoGasolina;

import java.util.Optional;

public class DataTest {
    public static Optional<VehiculoElectrico> ve01() {
        return Optional.of(new VehiculoElectrico("10101", "B80001", false, null, TipoBateriaEnum.GEL, 260, 16));
    }

    public static Optional<VehiculoGasolina> vg01() {
        return Optional.of(new VehiculoGasolina("10102", "B80002", false, null, "B100"));
    }

    public static Optional<VehiculoDiesel> vd01() {
        return Optional.of(new VehiculoDiesel("10103", "B80003", false, null, TipoBombaInyeccionEnum.LINEAL));
    }

}
