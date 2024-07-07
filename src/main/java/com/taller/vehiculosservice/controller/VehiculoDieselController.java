package com.taller.vehiculosservice.controller;

import com.taller.vehiculosservice.exception.RequestException;
import com.taller.vehiculosservice.model.dto.VehiculoDieselDTO;
import com.taller.vehiculosservice.payload.MessageResponse;
import com.taller.vehiculosservice.service.VehiculoDieselService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehiculoDiesel")
public class VehiculoDieselController {

    private VehiculoDieselService vehiculoService;

    @GetMapping
    public ResponseEntity<MessageResponse> getAll(){
        List<VehiculoDieselDTO> listado = vehiculoService.getAll();
        return listado!=null && !listado.isEmpty()
            ? new ResponseEntity<>( MessageResponse.builder().status(HttpStatus.OK).object(listado).message("Listado de inventarios de libros").build(),
                                    HttpStatus.OK)
            : new ResponseEntity<>( MessageResponse.builder().status(HttpStatus.NOT_FOUND).object(listado).message("Listado de inventarios de libros").build(),
                HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageResponse> getById(@PathVariable Integer id) throws RequestException {
        VehiculoDieselDTO dto = vehiculoService.getById(id);
        return dto!=null
                ? new ResponseEntity<>( MessageResponse.builder().status(HttpStatus.OK).object(dto).message(null).build(),
                HttpStatus.OK)
                : new ResponseEntity<>( MessageResponse.builder().status(HttpStatus.NOT_FOUND).object(dto).message("Elemento no encontrado").build(),
                HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody @Valid VehiculoDieselDTO dto) throws RequestException {
        VehiculoDieselDTO resultado = vehiculoService.create(dto);
        return new ResponseEntity<>( MessageResponse.builder().status(HttpStatus.OK).object(resultado).message(null).build(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> update( @PathVariable Integer id,
                                                   @RequestBody @Valid VehiculoDieselDTO dto) throws RequestException{
        VehiculoDieselDTO resultado = vehiculoService.update(id, dto);
        return new ResponseEntity<>( MessageResponse.builder().status(HttpStatus.OK).object(resultado).message(null).build(), HttpStatus.OK);
    }

}
