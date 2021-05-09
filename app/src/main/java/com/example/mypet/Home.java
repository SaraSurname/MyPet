package com.example.mypet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.mypet.Data.PetsDbHelper;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements View.OnClickListener{

 ImageView boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//pruebas para ver si funciona la bbdd
        PetsDbHelper mDbHelper = new PetsDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        ListView lista = (ListView) findViewById(R.id.mainContainerPrincipal);
        ArrayList<Pet> listaAnimales = new ArrayList<Pet>();
        Pet animal1 = new Pet("Kira", "Mini Pincher", 10, "Hembra");
        listaAnimales.add(animal1);
        Pet animal2 = new Pet("Ron", "Labrador", 30, "Macho");
        listaAnimales.add(animal2);
        Pet animal3 = new Pet("Rex", "Schnauzer", 8, "Macho");
        listaAnimales.add(animal3);
        Pet animal4 = new Pet("Gala", "Boxer", 15 , "Hembra");
        listaAnimales.add(animal4);
        Pet animal5 = new Pet("Luca", "Cocker", 9, "Macho");
        listaAnimales.add(animal5);
        Pet animal6 = new Pet("Buffy", "Westy", 6, "Hembra");
        listaAnimales.add(animal6);
        Pet animal7 = new Pet("Sony", "Blue Merle", 11, "Macho");
        listaAnimales.add(animal7);
        Pet animal8 = new Pet("Kira", "Blue Merle" , 9, "Hembra");
        listaAnimales.add(animal8);


        PetAdapter petAdapter = new PetAdapter(this, 0, listaAnimales);
        lista.setAdapter(petAdapter);

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(view.getContext(), Actualizar.class);
                intent.putExtra("nombre", listaAnimales.get(i).getNombre());
                intent.putExtra("raza", listaAnimales.get(i).getRaza());
                intent.putExtra("peso", listaAnimales.get(i).getPeso());


                if(listaAnimales.get(i).getGenero().equalsIgnoreCase("Macho")){
                    intent.putExtra("genero", "Macho");
                }else if(listaAnimales.get(i).getGenero().equalsIgnoreCase("Hembra")){
                    intent.putExtra("genero", "Hembra");
                }
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