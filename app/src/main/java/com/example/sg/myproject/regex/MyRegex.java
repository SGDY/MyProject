package com.example.sg.myproject.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author SGDY
 * @version 1.0
 * @description
 * @createDate 2015/1/27
 */
public class MyRegex {
    public static void main(String[] args) {
        String pattern = "(1)";
        String input = "123456";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        if (m.find()) {

        }
    }
}
