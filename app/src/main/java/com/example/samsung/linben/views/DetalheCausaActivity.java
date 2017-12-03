package com.example.samsung.linben.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.widget.TextView;

import com.example.samsung.linben.R;
import com.example.samsung.linben.models.Causa;

import org.w3c.dom.Text;

public class DetalheCausaActivity extends AppCompatActivity {

    TextView tv_nome;
    TextView tv_tipo_sanguineo;
    TextView tv_tipo_doenca;
    TextView tv_descricao;

    int position;
    Causa causa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_causa);

        tv_nome = findViewById(R.id.tv_nome);
        tv_tipo_sanguineo = findViewById(R.id.tv_tipo_sanguineo);
        tv_tipo_doenca = findViewById(R.id.tv_tipo_doenca);
        tv_descricao = findViewById(R.id.tv_descricao);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            position = intent.getIntExtra("position", 0);
            causa = new Causa();
            causa.setId(bundle.getInt("id"));
            causa.setNome(bundle.getString("nome"));
            causa.setTipoSanguineo(bundle.getString("tipoSanguineo"));
            causa.setTipoDoenca(bundle.getString("tipoDoenca"));
            causa.setDescricao(bundle.getString("descricao"));

            tv_nome.setText(intent.getStringExtra("nome"));
            tv_tipo_sanguineo.setText(intent.getStringExtra("tipoSanguineo"));
            tv_tipo_doenca.setText(intent.getStringExtra("tipoDoenca"));
            tv_descricao.setText(intent.getStringExtra("descricao"));
        }

    }
}
