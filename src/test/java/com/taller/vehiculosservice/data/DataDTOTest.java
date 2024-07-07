package com.taller.vehiculosservice.data;

import com.taller.vehiculosservice.model.dto.VehiculoDieselDTO;
import com.taller.vehiculosservice.model.dto.VehiculoElectricoDTO;
import com.taller.vehiculosservice.model.dto.VehiculoGasolinaDTO;
import com.taller.vehiculosservice.model.enumtypes.TipoBateriaEnum;
import com.taller.vehiculosservice.model.enumtypes.TipoBombaInyeccionEnum;

public class DataDTOTest {
    public static VehiculoElectricoDTO vehEDTO01() {
        return new VehiculoElectricoDTO("20101", "M80001", false, null, TipoBateriaEnum.GEL.toString(), 260, 16);
    }

    public static VehiculoElectricoDTO vehEInvalidDTO01() {
        return new VehiculoElectricoDTO("20101", "M80001", false, null, "NIQUEL", 260, 16);
    }

    public static VehiculoGasolinaDTO vehGDTO02() {
        return new VehiculoGasolinaDTO("30101", "G80001", false, null, "B90");
    }

    public static VehiculoDieselDTO vehDDTO01() {
        return new VehiculoDieselDTO("60101", "D80001", false, null, TipoBombaInyeccionEnum.LINEAL.toString());
    }

    public static VehiculoDieselDTO vehDDTO02() {
        return new VehiculoDieselDTO("60115", "D80021", false, null, TipoBombaInyeccionEnum.ROTATORIA.toString());
    }

}
