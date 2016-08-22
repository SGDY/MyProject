package com.example.sgdy.emoji;

import android.content.Context;
import android.text.SpannableStringBuilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sgdy on 16/8/22.
 */
public class util {

    public static SpannableStringBuilder parseEmo(Context context, String str) {
        SpannableStringBuilder builder = new SpannableStringBuilder();

        Pattern pattern = Pattern.compile("\\[xxx_(.*?)\\]");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String emo = matcher.group();
            emo = emo.substring(1, emo.length() - 1);
            //获取表情的id
            int id = context.getResources().getIdentifier(emo, "mipmap", context.getPackageName());
        }
        return builder;
    }
}
