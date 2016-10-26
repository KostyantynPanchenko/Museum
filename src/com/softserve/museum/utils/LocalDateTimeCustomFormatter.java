package com.softserve.museum.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeCustomFormatter {
   
    private static final DateTimeFormatter patern = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    
    public LocalDateTimeCustomFormatter() {
        System.out.println("Formatter created");
    }
    
    public String format(LocalDateTime value) {
        return value.format(patern);
    }
}
