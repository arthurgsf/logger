package com.arthurgsf.logger.controller;
import java.util.List;

import com.arthurgsf.logger.model.entity.Log;
import com.arthurgsf.logger.model.entity.LogComparator;
import com.arthurgsf.logger.model.entity.Maquina;
import com.arthurgsf.logger.service.LogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/log")
public class LogController {
    @Autowired
    LogService logSrv;

    @GetMapping("/{id}")
    /* Busca todos os logs associados à uma determinada máquina */
    /* URL NO FORMATO : api/log/id */
    public ResponseEntity buscar(@PathVariable("id") Long idMaquina){
        try{
            /* Constroi um Log com id_maquina = {id} para ser utilizado como example matcher na camada service*/
            Log l = Log.builder().maquina(Maquina.builder().id(idMaquina).build()).build();
            List<Log> lista = logSrv.buscar(l);
            lista.sort(new LogComparator()); //ordenação de acordo com a regra definida no LogComparator
            return new ResponseEntity(lista, HttpStatus.OK);

        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
