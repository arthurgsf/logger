package com.arthurgsf.logger.model.repo;

import com.arthurgsf.logger.model.entity.Log;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
    
}
