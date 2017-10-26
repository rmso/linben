package com.example.samsung.linben;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

/**
 * Created by Raquel on 06/07/2016.
 */
public class SobreActivity extends AppCompatActivity {

    private Button btn_voltar;
    private Button btn_ajuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        btn_voltar = (Button) findViewById(R.id.voltarseta);
        btn_ajuda = (Button) findViewById(R.id.ajuda);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               Intent i = new Intent(SobreActivity.this, MenuActivity.class);
                                               startActivity(i);
                                           }
                                       }
        );


        btn_ajuda.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(SobreActivity.this, AjudaActivity.class);
                                              startActivity(i);
                                          }
                                      }
        );

    }
}
