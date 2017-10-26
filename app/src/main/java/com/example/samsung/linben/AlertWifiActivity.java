package com.example.samsung.linben;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;

/**
 * Created by Samsung on 03/06/2016.
 */
public class AlertWifiActivity extends Activity{
    //atributo da classe.
    private AlertDialog alerta;
    private Button btn_fechar;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //LayoutInflater é utilizado para inflar nosso layout em uma view.
        //-pegamos nossa instancia da classe
        LayoutInflater li = getLayoutInflater();
        View view = li.inflate( R.layout.activity_alerta_wifi,null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        final AlertDialog alerta = builder.create();

//definimos para o botão do layout um clickListener

        view.findViewById(R.id.fechar).setOnClickListener(new View.OnClickListener() {


            public void onClick(View arg0) { //exibe um Toast informativo.

              //  Toast.makeText(AlertWifiActivity.this, "alerta.dismiss()", Toast.LENGTH_SHORT).show(); //desfaz o alerta.
                Intent i = new Intent(AlertWifiActivity.this, MenuActivity.class);
                startActivity(i);
              //  alerta.dismiss();

            }

        });


        alerta.show();

    }
}

