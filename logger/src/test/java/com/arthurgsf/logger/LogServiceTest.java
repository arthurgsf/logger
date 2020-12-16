package com.arthurgsf.logger;

import java.util.List;

import com.arthurgsf.logger.model.entity.Log;
import com.arthurgsf.logger.model.entity.Maquina;
import com.arthurgsf.logger.model.repo.LogRepository;
import com.arthurgsf.logger.service.LogService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LogServiceTest {
    @Autowired
    LogRepository logRepo;

    @Autowired
    LogService logService;

    @Test
    public void deveRetornarListaVaziaAoBuscarPorMaquinaInexistente(){
        Log log = Log.builder()
        .maquina(Maquina.builder()
        .id(-1)
        .build())
        .build();

        List<Log> busca = logService.buscar(log);
        Assertions.assertNotNull(busca);
        Assertions.assertTrue(busca.size() == 0);
    }

    @Test
    public void verificaBusca(){
        Log log = Log.builder()
        .maquina(Maquina.builder()
        .id(1)
        .build())
        .build();

        List<Log> busca = logService.buscar(log);
        Assertions.assertNotNull(busca);
        Assertions.assertTrue(busca.size() > 0);
        for (Log l : busca) {
            Assertions.assertEquals(log.getMaquina().getId(), l.getMaquina().getId());
        }
    }
}
