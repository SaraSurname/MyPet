package com.example.mypet.Data;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mypet.Data.UserContract.PetEntry;
import com.example.mypet.Pet;


public class PetsDbHelper extends SQLiteOpenHelper {

    //nombre de la bbdd
    private static final String DATABASE_NAME = "pets.db";
    //Version actual de la bbdd, si cambiamos el esquema tendremos que actualizar este dato
    private static final int DATABASE_VERSION = 1;

    public PetsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //inserts,
    public long insertPet (Pet pet){
        //que la base de datos sea 'escribible'
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        //introducimos la CLAVE y el VALOR por cada dato. Es decir, la columna y su valor
        contentValues.put(PetEntry.COLUMN_PET_NAME, pet.getNombre());
        contentValues.put(PetEntry.COLUMN_PET_BREED, pet.getRaza());
        contentValues.put(PetEntry.COLUMN_PET_WEIGHT, pet.getPeso());
        contentValues.put(PetEntry.COLUMN_PET_GENDER, pet.getGenero());

        //nos devuelve un identificador de la fila que acaba de insertar
        //long newRowId comprobamos que id nos devuelve
        long newRowId =  db.insert(PetEntry.TABLE_NAME, null, contentValues);

        return newRowId;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //creacion de la bbdd
        //creacion de una tabla
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + PetEntry.TABLE_NAME +
                "("
                + PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, "
                + PetEntry.COLUMN_PET_BREED + " TEXT NOT NULL, "
                + PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0, "
                + PetEntry.COLUMN_PET_GENDER + " TEXT NOT NULL);";
        sqLiteDatabase.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //destruccion, y posterior llamada al onCreate para volver a crearla y así estar actualizada
    }
}
