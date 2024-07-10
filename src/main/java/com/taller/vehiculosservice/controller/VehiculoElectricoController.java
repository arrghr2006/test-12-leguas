package com.taller.vehiculosservice.controller;

import com.taller.vehiculosservice.exception.RequestException;
import com.taller.vehiculosservice.model.dto.VehiculoElectricoResponseDTO;
import com.taller.vehiculosservice.payload.MessageResponse;
import com.taller.vehiculosservice.service.VehiculoElectricoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.taller.vehiculosservice.model.dto.VehiculoElectricoDTO;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehiculoElectrico")
public class VehiculoElectricoController {

    private VehiculoElectricoService vehiculoService;

    @GetMapping
    public ResponseEntity<MessageResponse> getAll(){
        List<VehiculoElectricoResponseDTO> listado = vehiculoService.getAll();
        return listado!=null && !listado.isEmpty()
            ? new ResponseEntity<>( MessageResponse.builder().status(HttpStatus.OK).object(listado).message("Listado de inventarios de libros").build(),
                                    HttpStatus.OK)
            : new ResponseEntity<>( MessageResponse.builder().status(HttpStatus.NOT_FOUND).object(listado).message("Listado de inventarios de libros").build(),
                HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageResponse> getById(@PathVariable Integer id) throws RequestException {
        VehiculoElectricoResponseDTO dto = vehiculoService.getById(id);
        return dto!=null
                ? new ResponseEntity<>( MessageResponse.builder().status(HttpStatus.OK).object(dto).message(null).build(),
                HttpStatus.OK)
                : new ResponseEntity<>( MessageResponse.builder().status(HttpStatus.NOT_FOUND).object(dto).message("Elemento no encontrado").build(),
                HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody @Valid VehiculoElectricoDTO dto) throws RequestException {
        VehiculoElectricoResponseDTO resultado = vehiculoService.create(dto);
        return new ResponseEntity<>( MessageResponse.builder().status(HttpStatus.OK).object(resultado).message(null).build(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> update( @PathVariable Integer id,
                                                   @RequestBody @Valid VehiculoElectricoDTO dto) throws RequestException{
        VehiculoElectricoResponseDTO resultado = vehiculoService.update(id, dto);
        return new ResponseEntity<>( MessageResponse.builder().status(HttpStatus.OK).object(resultado).message(null).build(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> eliminar(@PathVariable Integer id) {
        vehiculoService.delete(id);
        return new ResponseEntity<>( MessageResponse.builder().status(HttpStatus.OK).object(null).message("Se eliminó el vehiculo correctamente").build(), HttpStatus.OK);
    }
}
