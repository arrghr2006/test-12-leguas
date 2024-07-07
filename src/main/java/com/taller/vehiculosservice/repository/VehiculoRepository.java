package com.taller.vehiculosservice.repository;

import com.taller.vehiculosservice.model.persistencia.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    @Query("Select ve From Vehiculo ve Where ve.vin=:vin or ve.matricula=:matricula ")
    public Optional<Vehiculo> findVehiculoByVinMatricula(String vin, String matricula);

    @Query(value =
        "select v.tipo, v.reconvertir, v.tipo_reconvertido, " +
            "(case when tipo='ELECTRICO' then concat(v.vin, ',', ve.tipo_bateria,',', ve.Voltaje,',', ve.Corriente,',',v.matricula) " +
            "      when tipo='DIESEL' then concat(v.matricula,',',vd.tipo_bomba_inyeccion) " +
            "      when tipo='GASOLINA' then concat(v.matricula,',', vg.tipos_gasolina) " +
            " end) as info " +
        "from vehiculo v " +
            "  left join vehiculo_electrico ve ON (v.id=ve.id) " +
            "  left join vehiculo_diesel vd on (v.id=vd.id) " +
            "  left join vehiculo_gasolina vg on (v.id=vg.id)", nativeQuery = true)
    public List<Object[]> listarTodos();

    @Query("Select v from Vehiculo v where v.vin=:vin")
    public Optional<Vehiculo> findVehiculoByVin(String vin);

    @Query("Select v from Vehiculo v where v.matricula=:matricula")
    public Optional<Vehiculo> findVehiculoByMatricula(String matricula);


}
