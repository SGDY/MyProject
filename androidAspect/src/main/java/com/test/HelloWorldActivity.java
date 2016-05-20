package com.test;

import android.app.Activity;
import android.os.Bundle;

public class HelloWorldActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        test1();
    }
    
    public void test1(){
    	test1_1();
    	test1_2();
    }
    
    public void test1_1(){
    	System.out.println("test1_1()");
    }
    
    public void test1_2(){
    	System.out.println("test1_2()");
    }
}
