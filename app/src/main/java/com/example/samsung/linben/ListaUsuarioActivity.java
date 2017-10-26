package com.example.samsung.linben;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.samsung.linben.database.DataBase;
import com.example.samsung.linben.entidades.Usuario;

/**
 * Created by Raquel on 23/06/2016.
 */
public class ListaUsuarioActivity extends ActionBarActivity {

   // private ListView listViewUsuario;
   public static final int CONST_TELA_TESTE  = 1;
    private ArrayAdapter<Usuario> adpUsuarios;
    private ListView listViewUsuario;
    private DataBase database;
    private SQLiteDatabase dbActions;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuario);

        this.listViewUsuario = (ListView) findViewById(R.id.listViewUsuario);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle params = intent.getExtras();
            if (params != null) {

                //CONTINUAR ESSE COISINHA
            }


            try {
                database = new DataBase(this);
                dbActions = database.getWritableDatabase();
                adpUsuarios = database.buscarUsuario(this);
                listViewUsuario.setAdapter(adpUsuarios);

            } catch (SQLException ex) {

                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setMessage("Erro ao criar o banco!" + ex.getMessage());
                dlg.setNegativeButton("OK", null);
                dlg.show();

            }
        }
    }

    public void onClick(View view){
        Intent i = new Intent(this,CadastroActivity.class);
        startActivityForResult(i,CONST_TELA_TESTE);

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        adpUsuarios = database.buscarUsuario(this);
        listViewUsuario.setAdapter(adpUsuarios);
    }
}


