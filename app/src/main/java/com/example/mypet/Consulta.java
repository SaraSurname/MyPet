package com.example.mypet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mypet.Data.PetsDbHelper;

public class Consulta extends AppCompatActivity {
    Spinner generos;
    EditText editnombre, editraza, editpeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta);

        generos = findViewById(R.id.spinnerGenero);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.generos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.preference_category);
        generos.setAdapter(adapter);

        generos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!parent.getItemAtPosition(position).toString().equalsIgnoreCase("Select...")) {
                    Toast.makeText(getApplicationContext(), "Seleccionado: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        editnombre = findViewById(R.id.editNombre);
        editraza = findViewById(R.id.editRaza);
        editpeso = findViewById(R.id.editPeso);
    }

    public void onClickCrear(View view) {
        // verificarCampos();
        if (verificarCampos() == true) {
            newInsert();
            Intent i = new Intent(view.getContext(), Home.class);
            startActivity(i);

        }

    }

    public void newInsert() {
        //verificar que los campos no estan vacíos

//asignar valores a cada campo
        String nombre = editnombre.getText().toString();
        String raza = editraza.getText().toString();
        double peso = Integer.parseInt(editpeso.getText().toString());
        String genero = generos.getSelectedItem().toString();
//añadir a nuevo objeto Pet
        Pet pet = new Pet(nombre, raza, peso, genero);
        PetsDbHelper petDbHelper = new PetsDbHelper(this);
        double test = petDbHelper.insertPet(pet);
        //para ver que hace bien el insert
        Log.i("ID nueva entrada: ", "" + test);
        Toast.makeText(this, "Creado correctamente", Toast.LENGTH_SHORT).show();
       /* Toast.makeText(this, "Nombre: " + pet.getNombre() +
                ".Raza: " + pet.getRaza() +
                ".Géreno: " + pet.getGenero() +
                ".Peso: " + pet.getPeso() + " kg",
                Toast.LENGTH_SHORT).show();*/
    }

    public boolean verificarCampos() {
        boolean verified = false;
        if (editnombre.getText().toString().isEmpty() && editraza.getText().toString().isEmpty() &&
                editpeso.getText().toString().isEmpty() && generos.getSelectedItem().toString().equalsIgnoreCase("Select...")) {
            Toast.makeText(this, "Rellenar los campos...", Toast.LENGTH_SHORT).show();

        } else if (editnombre.getText().toString().isEmpty()) {
            Toast.makeText(this, "Rellenar NOMBRE", Toast.LENGTH_SHORT).show();
        } else if (editraza.getText().toString().isEmpty()) {
            Toast.makeText(this, "Rellenar RAZA", Toast.LENGTH_SHORT).show();
        } else if (generos.getSelectedItem().toString().equalsIgnoreCase("Select...")) {
            Toast.makeText(this, "Seleccionar GENERO", Toast.LENGTH_SHORT).show();
        } else if (editpeso.getText().toString().isEmpty()) {
            Toast.makeText(this, "Rellenar PESO", Toast.LENGTH_SHORT).show();
        } else {
            verified = true;
        }

        return verified;

    }


}
