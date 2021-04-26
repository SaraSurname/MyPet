package com.example.mypet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
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
            Intent i = new Intent(MainActivity.this, InitActivity.class) ;
            startActivity(i);
            finish();
            }
        };
        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 3000);

    }



}