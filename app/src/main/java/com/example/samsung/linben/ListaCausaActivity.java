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
import com.example.samsung.linben.entidades.Causa;

/**
 * Created by Raquel on 04/07/2016.
 */
public class ListaCausaActivity extends ActionBarActivity {

    public static final int CONST_TELA_TESTE1  = 1;
    private ArrayAdapter<Causa> adpCausas;
    private ListView listViewCausa;
    private DataBase database;
    private SQLiteDatabase dbActions;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_causa);

        this.listViewCausa = (ListView) findViewById(R.id.listViewCausa);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle params = intent.getExtras();
            if (params != null) {

                //CONTINUAR ESSE COISINHA
            }


            try {
                database = new DataBase(this);
                dbActions = database.getWritableDatabase();
                adpCausas = database.buscarCausa(this);
                listViewCausa.setAdapter(adpCausas);

            } catch (SQLException ex) {

                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setMessage("Erro ao criar o banco!" + ex.getMessage());
                dlg.setNegativeButton("OK", null);
                dlg.show();

            }
        }
    }

    public void onClick(View view){
        Intent i = new Intent(this,ApeloActivity.class);
        startActivityForResult(i,CONST_TELA_TESTE1);

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        adpCausas = database.buscarCausa(this);
        listViewCausa.setAdapter(adpCausas);
    }
}
