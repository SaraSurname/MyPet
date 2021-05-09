package com.example.mypet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity  {

    ImageView boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
            Intent i = new Intent(MainActivity.this, Home.class) ;
            startActivity(i);
            finish();
            }
        };
        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 2000);

    }



}