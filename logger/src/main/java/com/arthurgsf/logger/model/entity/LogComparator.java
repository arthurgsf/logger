package com.arthurgsf.logger.model.entity;
import java.util.Comparator;

public class LogComparator implements Comparator<Log> {
    @Override
    public int compare(Log firstLog, Log secondLog) {
       return secondLog.getData().compareTo(firstLog.getData());
    }
}