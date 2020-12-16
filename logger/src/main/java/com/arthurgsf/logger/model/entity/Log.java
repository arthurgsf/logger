package com.arthurgsf.logger.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="log")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="consumo_cpu")
    private double consumoCpu;

    @Column(name="consumo_memoria")
    private double consumoMemoria;

    @Column(name="consumo_disco")
    private double consumoDisco;

    @Column(name="consumo_gpu")
    private double consumoGpu;
    
    @Column(name="data")
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "id_maquina")
    private Maquina usuario;
}
