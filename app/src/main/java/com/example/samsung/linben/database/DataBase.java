package com.example.samsung.linben.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.widget.ArrayAdapter;

import com.example.samsung.linben.models.*;

import com.example.samsung.linben.models.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raquel on 01/07/2016.
 */
public class DataBase {

    private SQLiteDatabase db;


    public DataBase(Context context){
        DataBaseHelper bdHelper = new DataBaseHelper(context);
        db = bdHelper.getWritableDatabase();
    }



    public void insertUser(Usuario usuario){ //inserindo usuario.

       // db = this.getWritableDatabase();//pegando a referencia da classe DATABASE.
        ContentValues values = new ContentValues();

        values.put("nome", usuario.getNome());
        values.put("email", usuario.getEmail());
        values.put("senha", usuario.getSenha());
        values.put("tipo_sanguineo", usuario.getTipo_sanguineo());
        values.put("genero", usuario.getGenero());
        values.put("data_nascimento", usuario.getData_nascimento());

        db.insertOrThrow("USUARIO", null, values);

    }

    public ArrayAdapter<Usuario> buscarUsuario(Context context){ //buscar usuario (listar ele numa list view)


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

        String query = "select email, senha from "+"USUARIO";
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


        ContentValues values = new ContentValues();

        values.put("descricao", causa.getDescricao());
        values.put("nome", causa.getNome());
        values.put("tipo_sanguineo", causa.getTipoSanguineo());
        values.put("tipo_doenca", causa.getTipoDoenca());


        db.insert("CAUSA", null, values);
    }

    public ArrayAdapter<Causa> buscarCausa(Context context){



        ArrayAdapter<Causa> adpCausas = new ArrayAdapter<Causa>(context, android.R.layout.simple_list_item_1);
        Cursor cursor = db.query("CAUSA",null,null,null,null,null,null);

        if (cursor.getCount() > 0){

            cursor.moveToFirst();

            do {
                Causa causa = new Causa();
                causa.setDescricao(cursor.getString(1));
                causa.setNome(cursor.getString(2));
                causa.setTipoSanguineo(cursor.getString(3));
                causa.setTipoDoenca(cursor.getString(4));

                adpCausas.add(causa);


            } while (cursor.moveToNext());
        }
        return adpCausas;
    }

    public List<Causa> buscarTodasCausas(){
        List<Causa> causaListReturn = new ArrayList<>();
        String[] colunas = new String[]{"descricao", "nome", "tipo_sanguineo", "tipo_doenca"};

        Cursor cursor = db.query("CAUSA", colunas, null, null, null, null, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();

            do {
                Causa causa = new Causa();
                causa.setDescricao(cursor.getString(0));
                causa.setNome(cursor.getString(1));
                causa.setTipoSanguineo(cursor.getString(2));
                causa.setTipoDoenca(cursor.getString(3));


                causaListReturn.add(causa);
            }while (cursor.moveToNext());
        }

        return causaListReturn;
    }


    public Causa selectCausa(Causa causa){
        Causa causa1 = new Causa();
        String[] colunas = new String[]{"id","descricao", "nome", "tipo_sanguineo", "tipo_doenca"};

        Cursor cursor = db.query("causa", colunas, null, null, null, null, "nome ASC");

        if (cursor.getCount() > 0){
            cursor.moveToFirst();

            do {
                causa.setId(cursor.getInt(0));
                causa.setDescricao(cursor.getString(1));
                causa.setNome(cursor.getString(2));
                causa.setTipoSanguineo(cursor.getString(3));
                causa.setTipoDoenca(cursor.getString(4));
            }while (cursor.moveToNext());
        }
        return causa1;
    }


}
