package com.gloomyer.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void click1(View v) {
        startActivity(new Intent(this, SimpleImageAct.class));
    }

    public void click2(View v) {
        startActivity(new Intent(this, MultiImageAct.class));
    }

}
