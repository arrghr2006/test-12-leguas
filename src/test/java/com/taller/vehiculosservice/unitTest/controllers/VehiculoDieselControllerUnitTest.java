package com.taller.vehiculosservice.unitTest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.taller.vehiculosservice.controller.VehiculoDieselController;
import com.taller.vehiculosservice.data.DataDTOTest;
import com.taller.vehiculosservice.model.dto.VehiculoDieselResponseDTO;
import com.taller.vehiculosservice.model.enumtypes.TipoBombaInyeccionEnum;
import com.taller.vehiculosservice.service.VehiculoDieselService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import static org.mockito.Mockito.*;

@WebMvcTest(VehiculoDieselController.class)
class VehiculoDieselControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private VehiculoDieselService vehiculoDieselService;

    @Test
    @DisplayName("Debe encontrar un vehiculo diesel.")
    void should_find_an_VehiculoDiesel() throws Exception {
        // Given
        Integer vehiculoDieselId = 2;
        when(this.vehiculoDieselService.getById(vehiculoDieselId)).thenReturn(DataDTOTest.vehDDTO01());

        // When
        ResultActions response = this.mockMvc.perform(MockMvcRequestBuilders.get("/vehiculoDiesel/{id}", vehiculoDieselId));

        // Then
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("object.vin").value("60101"))
                .andExpect(MockMvcResultMatchers.jsonPath("object.matricula").value("D80001"))
                .andExpect(MockMvcResultMatchers.jsonPath("object.tipoBombaInyeccion").value(TipoBombaInyeccionEnum.LINEAL.toString()));
        verify(this.vehiculoDieselService).getById(vehiculoDieselId);
    }

    @Test
    void should_find_all_VehiculoDiesels() throws Exception {
        // Given
        List<VehiculoDieselResponseDTO> vehiculoDieselList = List.of(DataDTOTest.vehDDTO01(), DataDTOTest.vehDDTO02());
        when(this.vehiculoDieselService.getAll()).thenReturn(vehiculoDieselList);

        // When
        ResultActions response = this.mockMvc.perform(MockMvcRequestBuilders.get("/vehiculoDiesel"));

        // Then
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("object[0].vin").value("60101"))
                .andExpect(MockMvcResultMatchers.jsonPath("object[0].matricula").value("D80001"))
                .andExpect(MockMvcResultMatchers.jsonPath("object[0].tipoBombaInyeccion").value(TipoBombaInyeccionEnum.LINEAL.toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("object[1].vin").value("60115"))
                .andExpect(MockMvcResultMatchers.jsonPath("object[1].matricula").value("D80021"))
                .andExpect(MockMvcResultMatchers.jsonPath("object[1].tipoBombaInyeccion").value(TipoBombaInyeccionEnum.ROTATORIA.toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("object.size()", Matchers.is(vehiculoDieselList.size())));

        verify(this.vehiculoDieselService).getAll();
    }

}