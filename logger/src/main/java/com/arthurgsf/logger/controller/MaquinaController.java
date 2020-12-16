package com.arthurgsf.logger.controller;

import java.util.List;

import com.arthurgsf.logger.model.entity.Maquina;
import com.arthurgsf.logger.service.MaquinaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/maquina")
public class MaquinaController {
    @Autowired MaquinaService maqSrv;

    @GetMapping
    public ResponseEntity listar(){
        try{
            List<Maquina> lista = maqSrv.listar();
            return new ResponseEntity(lista, HttpStatus.OK);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
