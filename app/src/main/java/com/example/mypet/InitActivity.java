package com.example.mypet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class InitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        ListView lista = (ListView) findViewById(R.id.mainContainerPrincipal);


        ArrayList<Pet> listaAnimales = new ArrayList<Pet>();
        Pet animal1 = new Pet("Kira", "Mini Pincher");
        listaAnimales.add(animal1);
        Pet animal2 = new Pet("Ron", "Labrador");
        listaAnimales.add(animal2);
        Pet animal3 = new Pet("Rex", "Schnauzer");
        listaAnimales.add(animal3);
        Pet animal4 = new Pet("Gala", "Boxer");
        listaAnimales.add(animal4);
        Pet animal5 = new Pet("Luca", "Cocker");
        listaAnimales.add(animal5);
        Pet animal6 = new Pet("Buffy", "Westy");
        listaAnimales.add(animal6);
        Pet animal7 = new Pet("Sony", "Blue Merle");
        listaAnimales.add(animal7);
        Pet animal8 = new Pet("Kira", "Blue Merle");
        listaAnimales.add(animal8);


        PetAdapter petAdapter = new PetAdapter(this, 0, listaAnimales);
        lista.setAdapter(petAdapter);


    }
}