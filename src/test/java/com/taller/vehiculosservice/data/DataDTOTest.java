package com.taller.vehiculosservice.data;

import com.taller.vehiculosservice.model.dto.*;
import com.taller.vehiculosservice.model.enumtypes.TipoBateriaEnum;
import com.taller.vehiculosservice.model.enumtypes.TipoBombaInyeccionEnum;

public class DataDTOTest {
    public static VehiculoElectricoResponseDTO vehEDTO01() {
        return new VehiculoElectricoResponseDTO(255, "20101", "M80001", false, null, TipoBateriaEnum.GEL.toString(), 260, 16);
    }

    public static VehiculoElectricoResponseDTO vehEInvalidDTO01() {
        return new VehiculoElectricoResponseDTO(256, "20101", "M80001", false, null, "NIQUEL", 260, 16);
    }

    public static VehiculoGasolinaResponseDTO vehGDTO02() {
        return new VehiculoGasolinaResponseDTO(257, "30101", "G80001", false, null, "B90");
    }

    public static VehiculoDieselResponseDTO vehDDTO01() {
        return new VehiculoDieselResponseDTO(258, "60101", "D80001", false, null, TipoBombaInyeccionEnum.LINEAL.toString());
    }

    public static VehiculoDieselResponseDTO vehDDTO02() {
        return new VehiculoDieselResponseDTO(259, "60115", "D80021", false, null, TipoBombaInyeccionEnum.ROTATORIA.toString());
    }

}
