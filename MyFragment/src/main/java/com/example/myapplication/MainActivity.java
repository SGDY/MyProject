package com.example.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.widget.Button;

import com.example.myapplication.fragment.AnotherRightFragment;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_left_right);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(v -> {
            AnotherRightFragment fragment = new AnotherRightFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.right_layout, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager.popBackStackImmediate()) {
            fragmentManager.popBackStack();
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
