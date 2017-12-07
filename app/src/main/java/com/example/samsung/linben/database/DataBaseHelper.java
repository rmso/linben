package com.example.samsung.linben.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Samsung on 05/12/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION = 2;
        private static final String DATABASE_NAME = "linbenDB";
        private static final String COLUMN_ID = "id";
        //usuários
        private static final String TABLE_NAME = "USUARIO";
        private static final String NAME = "nome";
        private static final String EMAIL = "email";
        private static final String PASSWORD = "senha";
        private static final String BLOOD_TYPE = "tipo_sanguineo";
        private static final String GENERE = "genero";
        private static final String BIRTH_DATE = "data_nascimento";
        //causas
        private static final String TABLE_NAME_CAUSA = "CAUSA";
        private static final String DESCRICAO = "descricao";
        private static final String NOME= "nome";
        private static final String TIPOSANGUINEO = "tipo_sanguineo";
        private static final String TIPODOENCA = "tipo_doenca";

        SQLiteDatabase db;

        private static final String TABLE_CREATE =
                "CREATE TABLE USUARIO(id integer PRIMARY KEY AUTOINCREMENT," +
                        "nome VARCHAR(40), email VARCHAR(20), senha VARCHAR(10), tipo_sanguineo VARCHAR(3), genero VARCHAR(10)," +
                        "data_nascimento VARCHAR(20));";


        private static final String TABLE_CREATE_CAUSA =
                "CREATE TABLE CAUSA(id integer PRIMARY KEY AUTOINCREMENT," +
                        "descricao VARCHAR(1000), nome VARCHAR(30), tipo_sanguineo VARCHAR(5), tipo_doenca VARCHAR(10));";


        public DataBaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(TABLE_CREATE_CAUSA);
            db.execSQL(TABLE_CREATE);

            this.db = db;
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
            String query1 = "DROP TABLE IF EXISTS "+TABLE_NAME_CAUSA;
            db.execSQL(query);
            db.execSQL(query1);
            this.onCreate(db);

        }

    }
