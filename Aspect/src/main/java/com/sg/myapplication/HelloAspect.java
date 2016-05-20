package com.sg.myapplication;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by sg
 * Created Time 2015/4/20 18:41
 * Description
 */
@Aspect
public class HelloAspect {
    @Pointcut("execution(* com..*.onActivityClick(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void beforePointcut() {
        Log.d("sg", "before");
    }

    @Around("pointcut()")
    public void weaveJoinPoint(JoinPoint joinPoint) {
        Log.d("sg", "around");
    }

    @After("pointcut()")
    public void afterPointcut() {
        Log.d("sg", "after");
    }

//    @AfterReturning("pointcut()")
//    public void afterReturnPointcut(Object o) {
//        Log.d("sg", o.toString());
//    }

//    @AfterThrowing("pointcut()")
//    public void afterThrowPointcut(Exception e) {
//        Log.d("sg", e.getMessage());
//    }

}
