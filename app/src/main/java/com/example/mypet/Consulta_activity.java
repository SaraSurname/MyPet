package com.example.mypet;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Consulta_activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    String [] generos = {"Male", "Female"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta);


        Spinner spinner = (Spinner) findViewById(R.id.spinnerGenero);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,generos);
        spinner.setAdapter(adapter);

    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),generos [position] , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
