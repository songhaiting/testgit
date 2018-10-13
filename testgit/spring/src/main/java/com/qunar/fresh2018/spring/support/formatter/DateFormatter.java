package com.qunar.fresh2018.spring.support.formatter;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日期格式化
 */
@Component public class DateFormatter implements Formatter<Date> {

    public Date parse(String str, Locale locale) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = df.parse(str);
        return d;

    }

    @Override public String print(Date date, Locale locale) {
        return date.toString();
    }
}