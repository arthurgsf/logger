package com.arthurgsf.logger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.arthurgsf.logger.controller.LogController;
import com.arthurgsf.logger.model.entity.Log;
import com.arthurgsf.logger.model.entity.Maquina;
import com.arthurgsf.logger.service.LogService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest (controllers =  LogController.class)
@AutoConfigureMockMvc
public class LogControllerTest {
    static final String API = "/api/log";

    @Autowired
    MockMvc mvc;

    @MockBean
    LogService service;

    @Test
    public void deveListarLogsPorMaquina() throws Exception{

        long idMaquina = 1;
        // resposta mockada
        Log l = Log.builder()
        .consumoCpu(20)
        .consumoDisco(30)
        .consumoGpu(40)
        .consumoMemoria(50)
        .data(LocalDateTime.now())
        .maquina(Maquina.builder().id(idMaquina).build())
        .build();
        
        List<Log> lista = new ArrayList<Log>();
        lista.add(l);

        //mock buscar
        Mockito.when(service.buscar(Mockito.any(Log.class))).thenReturn(lista);
        
        MockHttpServletRequestBuilder request = 
              MockMvcRequestBuilders.get(API.concat("/" + idMaquina));

        //ação
        mvc.perform(request)
        .andExpect(
            MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers
                .jsonPath("$[0].consumoCpu").value(20));
    }
}
