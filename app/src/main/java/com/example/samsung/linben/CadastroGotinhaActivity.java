package com.example.samsung.linben;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Raquel on 08/07/2016.
 */
public class CadastroGotinhaActivity extends AppCompatActivity {

    private Button btn_voltar;
    private Button btn_concluir;
    private Button btn_ajuda;

    EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_gotinha);

        btn_voltar = (Button) findViewById(R.id.voltarseta);
        btn_concluir = (Button) findViewById(R.id.concluir);
        btn_ajuda = (Button) findViewById(R.id.ajuda);
        id = (EditText) findViewById(R.id.id);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(CadastroGotinhaActivity.this, MenuActivity.class);
                                              startActivity(i);
                                          }
                                      }
        );

        btn_concluir.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                if (id.getText().length() == 0) {
                                                    Toast.makeText(getApplication(), "O campo ID é obrigatório", Toast.LENGTH_LONG).show();
                                                }else{
                                                    Toast.makeText(getApplication(), "Gotinha registrada!", Toast.LENGTH_LONG).show();
                                                    Intent i = new Intent(CadastroGotinhaActivity.this, MenuActivity.class);
                                                    startActivity(i);
                                                }
                                            }
                                        }
        );

        btn_ajuda.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(CadastroGotinhaActivity.this, AjudaActivity.class);
                                              startActivity(i);
                                          }
                                      }
        );

    }
}
