package com.arthurgsf.logger;

import java.util.List;

import com.arthurgsf.logger.model.entity.Log;
import com.arthurgsf.logger.model.entity.Maquina;
import com.arthurgsf.logger.model.repo.MaquinaRepository;
import com.arthurgsf.logger.service.MaquinaService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MaquinaServiceTest {
    @Autowired
    MaquinaRepository logRepo;

    @Autowired
    MaquinaService logService;

    @Test
    public void verificaListagem(){
        List<Maquina> busca = logService.listar();
        Assertions.assertNotNull(busca);
        Assertions.assertTrue(busca.size() > 0);
    }
}
