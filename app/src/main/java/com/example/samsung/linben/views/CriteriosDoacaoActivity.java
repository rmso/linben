package com.example.samsung.linben.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.samsung.linben.R;

public class CriteriosDoacaoActivity extends AppCompatActivity {

    private Button btn_voltar;
    private Button btn_ajuda;
    private Button btn_sim;
    private Button btn_nao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criterios_doacao);

        btn_voltar = (Button) findViewById(R.id.voltarseta);
        btn_ajuda = (Button) findViewById(R.id.ajuda);
        btn_sim = (Button) findViewById(R.id.sim);
        btn_nao = (Button) findViewById(R.id.nao);

        btn_ajuda.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(CriteriosDoacaoActivity.this, AjudaActivity.class);
                                              startActivity(i);
                                              finish();
                                          }
                                      }
        );

    }
}
