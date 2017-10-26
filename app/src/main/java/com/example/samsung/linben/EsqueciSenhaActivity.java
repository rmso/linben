package com.example.samsung.linben;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Raquel on 06/07/2016.
 */
public class EsqueciSenhaActivity extends AppCompatActivity {

    private Button btn_enviar;
    private Button btn_login;
    private Button btn_novo_usuario;
    private Button btn_ajuda;
    EditText email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueci_senha);

        btn_login = (Button) findViewById(R.id.bt_login);
        btn_novo_usuario = (Button) findViewById(R.id.bt_novo_usuario);
        btn_enviar = (Button) findViewById(R.id.enviar);
        btn_ajuda = (Button) findViewById(R.id.bt_ajuda);
        email = (EditText) findViewById(R.id.email);

        btn_login.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(EsqueciSenhaActivity.this, LoginActivity.class);
                                              startActivity(i);
                                          }
                                      }
        );

        btn_novo_usuario.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent i = new Intent(EsqueciSenhaActivity.this, CadastroActivity.class);
                                             startActivity(i);
                                         }
                                     }
        );

        btn_ajuda.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent i = new Intent(EsqueciSenhaActivity.this, AjudaActivity.class);
                                                    startActivity(i);
                                                }
                                            }
        );

        btn_enviar.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             if (email.getText().length()==0){
                                                 Toast.makeText(getApplication(), "O email é obrigatório", Toast.LENGTH_LONG).show();
                                             }else {
                                                 Intent i = new Intent(EsqueciSenhaActivity.this, EnviarActivity.class);
                                                 startActivity(i);
                                             }
                                         }
                                     }
        );



    }
}
