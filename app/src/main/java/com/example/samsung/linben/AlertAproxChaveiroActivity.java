package com.example.samsung.linben;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Samsung on 03/06/2016.
 */
public class AlertAproxChaveiroActivity extends Activity{

    private AlertDialog alerta;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //LayoutInflater é utilizado para inflar nosso layout em uma view.
        //-pegamos nossa instancia da classe
        LayoutInflater li = getLayoutInflater();
        View view = li.inflate( R.layout.activity_alerta_aproxchaveiro,null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        final AlertDialog alerta = builder.create();


        final Timer timer2 = new Timer();
        timer2.schedule(new TimerTask() {
            public void run() {
               alerta.dismiss();
                timer2.cancel(); //this will cancel the timer of the system
            }
        }, 10000);


        alerta.show();

    }
}
