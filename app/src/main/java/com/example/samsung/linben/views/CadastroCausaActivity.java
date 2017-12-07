package com.example.samsung.linben.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.samsung.linben.R;
import com.example.samsung.linben.database.DataBase;
import com.example.samsung.linben.models.Causa;

/**
 * Created by Raquel on 03/12/2017.
 */

public class CadastroCausaActivity extends AppCompatActivity {

    EditText et_nome;
    EditText et_tipo_sanguineo;
    EditText et_tipo_doenca;
    EditText et_descricao;
    Button btn_concluir;
    DataBase dataBase;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_causa);

        et_nome = (EditText) findViewById(R.id.et_nome);
        et_tipo_sanguineo = (EditText) findViewById(R.id.et_tipo_sanguineo);
        et_tipo_doenca = (EditText) findViewById(R.id.et_tipo_doenca);
        et_descricao = (EditText) findViewById(R.id.et_descricao);

        btn_concluir = (Button) findViewById(R.id.concluir);

        btn_concluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //recuperando as informações que será passada para próxima intent
                String nome = et_nome.getText().toString();
                String tipo_sanguineo = et_tipo_sanguineo.getText().toString();
                String tipo_doenca = et_tipo_doenca.getText().toString();
                String descricao = et_descricao.getText().toString();

                Intent intent = new Intent(CadastroCausaActivity.this, MenuActivity.class);

                intent.putExtra("nome", nome);
                intent.putExtra("tipo_sanguineo", tipo_sanguineo);
                intent.putExtra("tipo_doenca", tipo_doenca);
                intent.putExtra("descricao", descricao);

                dataBase = new DataBase(CadastroCausaActivity.this);

                Causa causa = new Causa(descricao, nome,tipo_sanguineo,tipo_doenca);
                dataBase.insertCausa(causa);
                startActivity(intent);
            }
        });

    }



}
