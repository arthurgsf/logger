package com.arthurgsf.logger.model.repo;

import com.arthurgsf.logger.model.entity.Maquina;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MaquinaRepository extends JpaRepository<Maquina, Long> {
    
}
