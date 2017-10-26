package com.example.samsung.linben;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.*;

import com.example.samsung.linben.database.DataBase;


public class LoginActivity extends AppCompatActivity  {


    private Button btn_listaUsuario;
    private Button btn_listarCausa;
    Button bt_novo_usuario;
    Button bt_entrar;
    Button bt_ajuda;
    Button bt_esqueci_senha;
    EditText email;
    EditText senha;

    private DataBase database;
    private SQLiteDatabase dbActions;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

            try {
                database = new DataBase(this);
                dbActions = database.getReadableDatabase();

                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
               // dlg.setMessage("Conexão criada com sucesso!");
                //dlg.setNegativeButton("OK", null);
                //dlg.show();
            }catch (SQLException ex){

                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setMessage("Erro ao criar o banco!" + ex.getMessage());
                dlg.setNegativeButton("OK", null);
                dlg.show();

            }


        //chamada dos objetos
        btn_listaUsuario = (Button) findViewById(R.id.btn_listarUsuario);
        btn_listarCausa = (Button) findViewById(R.id.btn_listarCausa);
        bt_novo_usuario = (Button) findViewById(R.id.bt_novo_usuario);
        bt_entrar = (Button) findViewById(R.id.entrar);
        bt_ajuda = (Button) findViewById(R.id.bt_ajuda);
        bt_esqueci_senha = (Button) findViewById(R.id.bt_esqueci_senha);
        email = (EditText) findViewById(R.id.email);
        senha = (EditText) findViewById(R.id.senha);
        bt_novo_usuario.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   Intent i = new Intent(LoginActivity.this, CadastroActivity.class);
                                                   startActivity(i);
                                               }
                                           }
        );

       bt_entrar.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {

                                             //verificar se campo login e senha estão vazios
                                             if (email.getText().length()==0 || senha.getText().length()==0){
                                                 Toast.makeText(getApplication(), "Os campos email e senha são obrigatórios", Toast.LENGTH_LONG).show();
                                                 //Intent j = new Intent(LoginActivity.this, LoginActivity.class);
                                                 //startActivity(j);
                                             }else{
                                                 String password = database.searchPassword(email.getText().toString());
                                                 if(senha.getText().toString().equals(password)){
                                                     Toast.makeText(getApplication(), "Seja bem vindo ao Linben!", Toast.LENGTH_LONG).show();
                                                     Intent i = new Intent(LoginActivity.this, MenuActivity.class);
                                                     startActivity(i);
                                                 }else {
                                                     Toast.makeText(getApplication(), "Email e Senha não conferem", Toast.LENGTH_SHORT).show();
                                                     //limpando os campos
                                                     email.setText("");
                                                     senha.setText("");
                                                 }
                                             }
                                         }
                                     }
        );

        btn_listaUsuario.setOnClickListener(new View.OnClickListener(){
            public void  onClick(View v){
                Intent i = new Intent(LoginActivity.this, ListaUsuarioActivity.class);
                startActivity(i);
            }
        });


        btn_listarCausa.setOnClickListener(new View.OnClickListener(){
            public void  onClick(View v){
                Intent i = new Intent(LoginActivity.this, ListaCausaActivity.class);
                startActivity(i);
            }
        });


        bt_esqueci_senha.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   Intent i = new Intent(LoginActivity.this,EsqueciSenhaActivity.class);
                                                   startActivity(i);
                                               }
                                           }
        );

        bt_ajuda.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent i = new Intent(LoginActivity.this, AjudaActivity.class);
                                                    startActivity(i);
                                                }
                                            }
        );

    }


}



