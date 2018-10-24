package com.zjh.project.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 18221 on 2018/10/23.
 */
public class DateFormatUtil implements Converter<String,Date> {
//转换器将字段从string 变成Date
    @Override
    public Date convert(String s) {
        if(s!=null && !"".equals(s)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = sdf.parse(s);
                return date;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
