package com.arthurgsf.logger.service;

import com.arthurgsf.logger.model.repo.MaquinaRepository;

import java.util.List;

import com.arthurgsf.logger.model.entity.Maquina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaquinaService {
    @Autowired
    MaquinaRepository repo;

    public List<Maquina> listar(){
        // retorna todas as máquinas cadastradas
        return repo.findAll();
    }
}
