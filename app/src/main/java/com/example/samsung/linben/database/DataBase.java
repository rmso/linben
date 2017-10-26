package com.example.samsung.linben.database;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.example.samsung.linben.entidades.*;

import com.example.samsung.linben.entidades.Usuario;

import java.util.Date;

/**
 * Created by Raquel on 01/07/2016.
 */
public class DataBase extends SQLiteOpenHelper{

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
    private static final String CIDADE= "cidade";
    private static final String ESTADO = "estado";
    private static final String HEMOCENTRO = "hemocentro";

    SQLiteDatabase db;

    private static final String TABLE_CREATE =
            "CREATE TABLE USUARIO(id integer PRIMARY KEY AUTOINCREMENT," +
            "nome VARCHAR(40), email VARCHAR(20), senha VARCHAR(10), tipo_sanguineo VARCHAR(3), genero VARCHAR(10)," +
            "data_nascimento VARCHAR(20));";


    private static final String TABLE_CREATE_CAUSA =
            "CREATE TABLE CAUSA(id integer PRIMARY KEY AUTOINCREMENT," +
                    "descricao VARCHAR(1000), cidade VARCHAR(20), estado VARCHAR(10), hemocentro VARCHAR(10));";

    public DataBase(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) { //quando for criada a database.
        db.execSQL(TABLE_CREATE_CAUSA);
        db.execSQL(TABLE_CREATE);

        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { //quando for atualizada a database.
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        String query1 = "DROP TABLE IF EXISTS "+TABLE_NAME_CAUSA;
        db.execSQL(query);
        db.execSQL(query1);
        this.onCreate(db);
    }

    public void insertUser(Usuario usuario){ //inserindo usuario.

        db = this.getWritableDatabase();//pegando a referencia da classe DATABASE.
        ContentValues values = new ContentValues();

        values.put(NAME, usuario.getNome());
        values.put(EMAIL, usuario.getEmail());
        values.put(PASSWORD, usuario.getSenha());
        values.put(BLOOD_TYPE, usuario.getTipo_sanguineo());
        values.put(GENERE, usuario.getGenero());
        values.put(BIRTH_DATE, usuario.getData_nascimento());

        db.insertOrThrow("USUARIO", null, values);
    }

    public ArrayAdapter<Usuario> buscarUsuario(Context context){ //buscar usuario (listar ele numa list view)

        db = this.getWritableDatabase();

        ArrayAdapter<Usuario> adpUsuarios = new ArrayAdapter<Usuario>(context, android.R.layout.simple_list_item_1);
        Cursor cursor = db.query("USUARIO",null,null,null,null,null,null);

        if (cursor.getCount() > 0){

            cursor.moveToFirst();

            do {
                Usuario usuario = new Usuario();
                usuario.setNome(cursor.getString(1));
                usuario.setEmail(cursor.getString(2));
                usuario.setSenha(cursor.getString(3));
                usuario.setTipo_sanguineo(cursor.getString(4));
                usuario.setGenero(cursor.getString(5));
                usuario.setData_nascimento(cursor.getString(6));

                adpUsuarios.add(usuario);


            } while (cursor.moveToNext());
        }
        return adpUsuarios;
    }

    public String searchPassword(String usuario) { //verificação de login.
        db = this.getReadableDatabase();
        String query = "select email, senha from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String userBank,passwordBank = "senhaerrada12317281027498";
        if(cursor.moveToFirst()){
            do{
                userBank = cursor.getString(0);
                if (userBank.equals(usuario)){
                    passwordBank = cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }

        return passwordBank;

    }

    public void insertCausa(Causa causa){ //inserindo causa.

        db = this.getWritableDatabase();//pegando a referencia da classe DATABASE.
        ContentValues values = new ContentValues();

        values.put(DESCRICAO, causa.getDescricao());
        values.put(CIDADE, causa.getCidade());
        values.put(ESTADO, causa.getEstado());
        values.put(HEMOCENTRO, causa.getHemocentro());

        db.insertOrThrow("CAUSA", null, values);
    }

    public ArrayAdapter<Causa> buscarCausa(Context context){

        db = this.getWritableDatabase();

        ArrayAdapter<Causa> adpCausas = new ArrayAdapter<Causa>(context, android.R.layout.simple_list_item_1);
        Cursor cursor = db.query("CAUSA",null,null,null,null,null,null);

        if (cursor.getCount() > 0){

            cursor.moveToFirst();

            do {
                Causa causa = new Causa();
                causa.setDescricao(cursor.getString(1));
                causa.setCidade(cursor.getString(2));
                causa.setEstado(cursor.getString(3));
                causa.setHemocentro(cursor.getString(4));

                adpCausas.add(causa);


            } while (cursor.moveToNext());
        }
        return adpCausas;
    }


}
