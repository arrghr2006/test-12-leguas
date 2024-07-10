package com.taller.vehiculosservice.model.dto;

import com.taller.vehiculosservice.model.enumtypes.TipoBateriaEnum;
import com.taller.vehiculosservice.model.enumtypes.TipoVehiculoEnum;
import lombok.*;

@Getter
@Setter
public class VehiculoElectricoReconvertirOutDTO extends VehiculoDTOOut{

    private TipoBateriaEnum tipoBateria;

    private Integer voltaje;

    private Integer corriente;

    private String vin;

    private String matricula;

    private TipoVehiculoEnum tipoReconvertido;

    public VehiculoElectricoReconvertirOutDTO( String tipoAReconvertir, String info){
        super(info);
        setTipoReconvertido(TipoVehiculoEnum.valueOf(tipoAReconvertir));
    }

    @Override
    protected void construyeDesdeString(String info){
        setTipo(TipoVehiculoEnum.ELECTRICO);
        if(info!=null && !info.isEmpty()){
            String[] infoSplitted = info.split(",");
            if(infoSplitted.length==5){
                setVin(infoSplitted[0]);
                setTipoBateria(TipoBateriaEnum.valueOf(infoSplitted[1]));
                setVoltaje(Integer.parseInt(infoSplitted[2]));
                setCorriente(Integer.parseInt(infoSplitted[3]));
                setMatricula(infoSplitted[4]);
            }
        }
    }
}
