package com.example.sg.myproject.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author SGDY
 * @version 1.0
 * @description
 * @createDate 2015/2/11
 */
public class MyDate {

    public static void main(String[] args){
        long dateOfBirth=-1574409957000L;
        Date date = new Date(dateOfBirth);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println(simpleDateFormat.format(date));
        boolean d = dateOfBirth < -1325664352000l;
        System.out.print(d);
    }

}
