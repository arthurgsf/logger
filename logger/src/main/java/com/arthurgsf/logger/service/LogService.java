package com.arthurgsf.logger.service;

import java.util.List;

import com.arthurgsf.logger.model.entity.Log;
import com.arthurgsf.logger.model.repo.LogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    @Autowired
    LogRepository repo;
    
    public List<Log> buscar(Log log){
        /* Monta um exemplo a partir do log passado */
        Example<Log> example = Example.of(log, ExampleMatcher.matchingAny());

        /* Encontra todos as entradas que tem pelo menos uma coluna igual ao exemplo dado */
        return repo.findAll(example);
    }
}
