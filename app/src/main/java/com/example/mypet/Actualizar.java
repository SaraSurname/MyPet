package com.example.mypet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.GenericLifecycleObserver;

public class Actualizar extends AppCompatActivity {
    Spinner spinner;
    EditText editnombre, editraza, editpeso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actualizar);

        spinner = findViewById(R.id.spinnerGenero);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.generos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


//traemos info de la lista
        String nombre = getIntent().getStringExtra("nombre");
        String raza = getIntent().getStringExtra("raza");
        String peso = getIntent().getStringExtra("peso");


//vistas HINT
        //nombre
        editnombre = findViewById(R.id.editNombre);
        editnombre.setHint(nombre);
        //raza
        editraza = findViewById(R.id.editRaza);
        editraza.setHint(raza);
        //peso
        editpeso = findViewById(R.id.editPeso);
        editpeso.setHint(peso);
        //genero
        //set del género según su posicion(método getPositionGender) pasamos el método
        //y el String que sacamos del Intent
        spinner.setSelection(getPositionGender(spinner, (getIntent().getStringExtra("genero"))));


    }

    public static int getPositionGender(Spinner spinner, String genero) {
        int posicion = 0;
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(genero)) {
                posicion = i;
            }
        }
        return posicion;
    }


}
