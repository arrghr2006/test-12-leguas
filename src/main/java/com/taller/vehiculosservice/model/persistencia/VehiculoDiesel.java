package com.taller.vehiculosservice.model.persistencia;

import com.taller.vehiculosservice.model.enumtypes.TipoBombaInyeccionEnum;
import com.taller.vehiculosservice.model.enumtypes.TipoVehiculoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vehiculo_diesel", schema="public")
@DiscriminatorValue(value="DIESEL")
@PrimaryKeyJoinColumn(name="id")
public class VehiculoDiesel extends Vehiculo{

    @Column( name="tipo_bomba_inyeccion", length = 15, nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoBombaInyeccionEnum tipoBombaInyeccion;

    public VehiculoDiesel(String vid, String chapa, Boolean aReconvertir, TipoVehiculoEnum newTipo, TipoBombaInyeccionEnum tipoBomba){
        super( vid, chapa, TipoVehiculoEnum.DIESEL, aReconvertir, newTipo);
        this.setTipoBombaInyeccion(tipoBomba);
    }

    public VehiculoDiesel(){
        super(TipoVehiculoEnum.ELECTRICO);
    }
}
