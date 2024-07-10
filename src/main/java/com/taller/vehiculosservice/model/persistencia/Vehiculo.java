package com.taller.vehiculosservice.model.persistencia;

import com.taller.vehiculosservice.model.enumtypes.TipoVehiculoEnum;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "vehiculo", schema="public",
        indexes = {
                @Index(name = "vehiculo_vinIndex", columnList = "vin", unique = true),
                @Index(name = "vehiculo_matriculaIndex", columnList = "matricula", unique = true),
                @Index(name = "vehiculo_tipoIndex", columnList = "tipo")
        })

public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial")
    private Integer id;

    @Column( unique = true, length = 10, nullable = false)
    private String vin;

    @Column(unique = true, length = 10, nullable = false)
    private String matricula;

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoVehiculoEnum tipo;

    @Column(nullable = false)
    private Boolean reconvertir = false;

    @Column(name="tipo_reconvertido", length = 10, nullable = true)
    @Enumerated(EnumType.STRING)
    private TipoVehiculoEnum tipoReconvertido;

    public Vehiculo(String vid, String chapa, TipoVehiculoEnum type, Boolean aReconvertir, TipoVehiculoEnum newTipo){
        super();
        this.setVin(vid);
        this.setMatricula(chapa);
        this.setTipo(type);
        this.setReconvertir(aReconvertir);
        this.setTipoReconvertido(newTipo);
    }

    public Vehiculo(TipoVehiculoEnum type){
        super();
        this.setTipo(type);
    }
}
