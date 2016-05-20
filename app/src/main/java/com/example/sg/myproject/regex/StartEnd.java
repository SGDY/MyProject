package com.example.sg.myproject.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author SGDY
 * @version 1.0
 * @description
 * @createDate 2015/1/27
 */
public class StartEnd {
    private static final String REGEX = "cat";
    private static final String INPUT = "catcatcatcattiecat";

    public static void main( String args[] ){
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // 获取 matcher 对象
        int count = 0;
        if (m.find(8)) {
            System.out.println(m.start());
        }
/*        while(m.find()) {
            count++;
            System.out.println("Match number "+count);
            System.out.println("start(): "+m.start());
            System.out.println("end(): "+m.end());
        }*/
    }
}
