package com.sg.databindingtest;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.sg.databindingtest.bean.User;
import com.sg.databindingtest.databinding.ActivityMainBinding;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("Test", "User");
        binding.setUser(user);
//        binding.setVariable(com.sg.databindingtest.BR.user, user);
        binding.setHandlers(new MyHandlers());
        binding.setPersenter(new Presenter());
        binding.tvFirstName.setText("User Test");
    }
}
