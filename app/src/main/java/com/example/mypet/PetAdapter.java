package com.example.mypet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class PetAdapter extends ArrayAdapter<Pet> {
    public PetAdapter(@NonNull Context context, int resource,  @NonNull ArrayList<Pet> pets) {
        super(context, resource,  pets);
    }


    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        View list_item = convertView;
        if (list_item == null) {
            list_item = LayoutInflater.from(getContext()).inflate(R.layout.item_list_pet, parent, false);

        }
        Pet currentPet = getItem(position);
        
        
        TextView textNombre = (TextView) list_item.findViewById(R.id.textNombre);
        textNombre.setText(currentPet.getNombre());
        TextView textRaza = (TextView) list_item.findViewById(R.id.textRaza);
        textRaza.setText(currentPet.getRaza());



        return list_item;


    }



}
