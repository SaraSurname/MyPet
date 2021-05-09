package com.example.mypet.Data;

import android.provider.BaseColumns;

public class UserContract {
    //Esta clase guarda todos los parametros de
    // interés de la bbdd que no queremos que sean modificables


    private UserContract() {

    }

    public static final class PetEntry implements BaseColumns {
        //static final - accesible y no modificable
        //Guardamos parametros. Nombre de la tabla, nombres de las columnas de la tabla
        public final static String TABLE_NAME = "pets";

        public final static String COLUMN_PET_NAME = "name";
        public final static String COLUMN_PET_BREED = "breed";
        public final static String COLUMN_PET_WEIGHT = "weight";
        public final static String COLUMN_PET_GENDER = "gender";


    }
}
