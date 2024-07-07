package com.taller.vehiculosservice.model.persistencia;

import com.taller.vehiculosservice.model.enumtypes.TipoBombaInyeccionEnum;
import com.taller.vehiculosservice.model.enumtypes.TipoVehiculoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vehiculo_gasolina", schema="public")
@DiscriminatorValue(value="GASOLINA")
@PrimaryKeyJoinColumn(name="id")
public class VehiculoGasolina extends Vehiculo {

    @Column(name="tipos_gasolina", length = 20, nullable = false)
    // Los valores vendrán en la forma B94 B100
    private String tiposGasolina;

    public VehiculoGasolina(String vid, String chapa, Boolean aReconvertir, TipoVehiculoEnum newTipo, String tipoGas){
        super( vid, chapa, TipoVehiculoEnum.GASOLINA, aReconvertir, newTipo);
        this.setTiposGasolina(tipoGas);
    }
}
