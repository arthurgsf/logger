package com.arthurgsf.logger;

import com.arthurgsf.logger.model.entity.Maquina;
import com.arthurgsf.logger.model.repo.MaquinaRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MaquinaRepositoryTest {
    @Autowired
    MaquinaRepository repo;

    @Test
    public void verificarSalvarMaquina(){
        //cenário
        Maquina novo = Maquina.builder()
        .nome("srv-deb-1")
        .build();
        

        //ação
        Maquina salvo = repo.save(novo);  //salva?

        //verificação
        Assertions.assertNotNull(salvo);
        Assertions.assertEquals(novo.getNome(), salvo.getNome());
    }
}
