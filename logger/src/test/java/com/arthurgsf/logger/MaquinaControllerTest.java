package com.arthurgsf.logger;


import java.util.ArrayList;
import java.util.List;

import com.arthurgsf.logger.controller.MaquinaController;

import com.arthurgsf.logger.model.entity.Maquina;
import com.arthurgsf.logger.service.MaquinaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest (controllers =  MaquinaController.class)
@AutoConfigureMockMvc
public class MaquinaControllerTest {
    static final String API = "/api/maquina";

    @Autowired
    MockMvc mvc;

    @MockBean
    MaquinaService service;

    @Test
    public void deveListarMaquinas() throws Exception{

        long idMaquina = 1;
        // resposta mockada
        Maquina m = Maquina.builder()
            .id(idMaquina)
            .nome("testemaquina")
            .build();
        
        List<Maquina> lista = new ArrayList<Maquina>();
        lista.add(m);

        //mock buscar
        Mockito.when(service.listar()).thenReturn(lista);
        
        MockHttpServletRequestBuilder request = 
            MockMvcRequestBuilders.get(API);

        //ação
        mvc.perform(request)
        .andExpect(
            MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers
                .jsonPath("$[0].nome").value("testemaquina"));
    }
}
