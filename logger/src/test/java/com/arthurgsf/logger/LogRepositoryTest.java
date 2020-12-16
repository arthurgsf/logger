package com.arthurgsf.logger;

import java.time.LocalDateTime;

import com.arthurgsf.logger.model.entity.Log;
import com.arthurgsf.logger.model.entity.Maquina;
import com.arthurgsf.logger.model.repo.LogRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LogRepositoryTest {
    @Autowired
    LogRepository repo;

    @Test
    public void verificarSalvarLog(){
        //cenário
        Log novo = Log.builder()
        .consumoCpu(20)
        .consumoDisco(30)
        .consumoGpu(40)
        .consumoMemoria(50)
        .data(LocalDateTime.now())
        .maquina(Maquina.builder().id(1).build())
        .build();
        

        //ação
        Log salvo = repo.save(novo);  //salva?

        //verificação
        Assertions.assertNotNull(salvo);
        Assertions.assertEquals(novo.getConsumoCpu(), salvo.getConsumoCpu());
        Assertions.assertEquals(novo.getConsumoDisco(), salvo.getConsumoDisco());
        Assertions.assertEquals(novo.getConsumoGpu(), salvo.getConsumoGpu());
        Assertions.assertEquals(novo.getConsumoMemoria(), salvo.getConsumoMemoria());
        Assertions.assertEquals(novo.getData(), salvo.getData());
        Assertions.assertEquals(novo.getMaquina().getId(), salvo.getMaquina().getId());
    }
}
