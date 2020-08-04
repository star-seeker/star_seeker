package com.imooc.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    public static Date stringToDate(String str, String format) {
        return Date.from(LocalDate.parse(str, DateTimeFormatter.ofPattern(format)).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

}
