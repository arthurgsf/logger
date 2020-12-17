package com.arthurgsf.logger.model.entity;
import java.util.Comparator;


/* Comparador utilizado para ordenar Logs por data, na ordem Inversa (mais recente primeiro) */
public class LogComparator implements Comparator<Log> {
    @Override
    public int compare(Log firstLog, Log secondLog) {
       return secondLog.getData().compareTo(firstLog.getData());
    }
}