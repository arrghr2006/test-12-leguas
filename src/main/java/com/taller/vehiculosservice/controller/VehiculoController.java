package com.taller.vehiculosservice.controller;

import com.taller.vehiculosservice.exception.RequestException;
import com.taller.vehiculosservice.model.dto.VehiculoDTO;
import com.taller.vehiculosservice.model.dto.VehiculoDTOOut;
import com.taller.vehiculosservice.payload.MessageResponse;
import com.taller.vehiculosservice.service.VehiculoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehiculos")
public class VehiculoController {

    private VehiculoService vehiculoService;

    @GetMapping
    public ResponseEntity<MessageResponse> getAll(){
        List<VehiculoDTOOut> listado = vehiculoService.getAll();
        return listado!=null && !listado.isEmpty()
            ? new ResponseEntity<>( MessageResponse.builder().status(HttpStatus.OK).object(listado).message("Listado de vehículos").build(),
                                    HttpStatus.OK)
            : new ResponseEntity<>( MessageResponse.builder().status(HttpStatus.NOT_FOUND).object(listado).message("Listado de vehículos").build(),
                HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageResponse> getById(@PathVariable Integer id) throws RequestException {
        VehiculoDTO dto = vehiculoService.getById(id);
        return dto!=null
                ? new ResponseEntity<>( MessageResponse.builder().status(HttpStatus.OK).object(dto).message(null).build(),
                HttpStatus.OK)
                : new ResponseEntity<>( MessageResponse.builder().status(HttpStatus.NOT_FOUND).object(dto).message("Elemento no encontrado").build(),
                HttpStatus.NOT_FOUND);
    }
    
}
