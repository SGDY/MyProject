package com.example.sg.myproject;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MainActivityBarActivity extends ActionBarActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener((v) -> Toast.makeText(this, "lambda", Toast.LENGTH_LONG).show());
    }


    void example1() {
        List<String> lists = new ArrayList<>();
        Collections.sort(lists, (o1, o2) -> o1.compareTo(o2));//list排序
    }

    void example2() {
        //(int x, int y) -> { return x + y; }
        //(x, y) -> x + y
        //x -> x * x
        //() -> x
        //x -> { System.out.println(x); }
    }

    void example3(){
        Arrays.sort(new String[]{}, new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                int result = Integer.compare(lhs.length(), rhs.length());
                return result;
            }
        });

        Arrays.sort(new String[]{}, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        Runnable r = () -> System.out.print("s");

    }

/*    void appendAll(Iterable values, Appendable out)
    { // 与lambda中的exception无关
        values.forEach(s -> {
            out.append(s); // 错误：这里不能抛出异常，因为Consumer.accept(T)没有如此约定
        });
    }*/

    void example4(){
/*        int x = 5;
        return y -> x + y;

        int count = 0;
        List strings = Arrays.asList("a", "b", "c");
        strings.forEach(s -> {
            count++; // 错误：不能更改count的值
        });

        Func[] array = new Func[10];
        for (int i = 0; i < array.length; i++) {
            final int temp = i;
            array[i] = int x -> x + temp ;
        }*/
/*        () -> Math.PI * 2.0
        (int i) -> i * 2
        (String s) -> s.length()
        (int i0, int i1) -> i0 + i1
        (int x, int y) -> { return x + y; }*/
    }

    void example5() {
        //省略类型
        //(int x, int y) -> { return x + y; };
        //(x, y) -> { return x + y; };

        //1个参数可以省略括号
        /*(String text) -> { System.out.println(text); };
        (text) -> { System.out.println(text); };
        text -> { System.out.println(text); };*/

        //函数体多行时需要大括号
/*        (int i) -> {
            int prod = 1;
            for(int n = 0; n < 5; n++) prod *= i;
            return prod;
        };*/

        //函数体只有一行的话可以省略大括号
        //text -> System.out.println(text);

        //只有一行代码而且有返回值的可以省略return，会返回该行代码计算结果
        /*(x, y) -> { return x -y; };
        (x, y) -> x -y;*/

        //没有参数没有返回值的空函数
        //() -> {};

        TextListener textListener = () -> System.out.print("");
        textListener.Run();

        TextListener1 textListener1 = x -> x ++;
        textListener1.Run(0);

        TextListener2 textListener2 = (x,y) -> {};

        TextListener3 textListener3 = x -> x;

    }

    public interface TextListener{
        void Run();
    }

    public interface TextListener1{
        void Run(int x);
    }

    public interface TextListener2{
        void Run(int x,int y);
    }

    public interface TextListener3{
        int Run(int x);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
