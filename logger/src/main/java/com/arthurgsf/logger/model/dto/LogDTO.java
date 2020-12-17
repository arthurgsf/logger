package com.arthurgsf.logger.model.dto;

import java.time.LocalDateTime;

import com.arthurgsf.logger.model.entity.Maquina;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/* Não utilizado mas adicionado por precaução */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogDTO {
    private long id;
    private double consumoCpu;
    private double consumoMemoria;
    private double consumoDisco;
    private double consumoGpu;
    private LocalDateTime data;
    private Maquina usuario;
}
