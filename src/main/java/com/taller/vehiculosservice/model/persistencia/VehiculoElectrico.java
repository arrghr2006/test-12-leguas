package com.taller.vehiculosservice.model.persistencia;

import com.taller.vehiculosservice.model.enumtypes.TipoBateriaEnum;
import com.taller.vehiculosservice.model.enumtypes.TipoVehiculoEnum;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "vehiculo_electrico", schema="public")
@DiscriminatorValue(value="ELECTRICO")
@PrimaryKeyJoinColumn(name="id")
public class VehiculoElectrico extends Vehiculo{

    @Column(name="tipo_bateria", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoBateriaEnum tipoBateria;

    @Column(nullable = false)
    private Integer voltaje;

    @Column(nullable = false)
    private Integer corriente;

    public VehiculoElectrico(String vid, String chapa, Boolean aReconvertir, TipoVehiculoEnum newTipo,
                             TipoBateriaEnum tipoBateria, Integer voltBat, Integer corrienteBateria ){
        super( vid, chapa, TipoVehiculoEnum.ELECTRICO, aReconvertir, newTipo);
        this.setTipoBateria(tipoBateria);
        this.setVoltaje(voltBat);
        this.setCorriente(corrienteBateria);
    }

    public VehiculoElectrico(){
        super( TipoVehiculoEnum.ELECTRICO );
    }

}
