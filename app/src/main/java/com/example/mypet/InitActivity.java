package com.example.mypet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class InitActivity extends AppCompatActivity implements View.OnClickListener{

 ImageView boton;

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

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(view.getContext(), Actualizar.class);
                startActivity(intent);
            }
        };

        lista.setOnItemClickListener(onItemClickListener);



        //funcionalidad boton de la huella
        boton =  findViewById(R.id.huellaBoton);
        boton.setOnClickListener(this);

        boton.setOnClickListener(view -> {
            Intent  i = new Intent(view.getContext(), Consulta.class);
            startActivity(i);

        });
    }


    @Override
    public void onClick(View v) {

    }
}