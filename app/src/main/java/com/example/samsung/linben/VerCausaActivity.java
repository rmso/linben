package com.example.samsung.linben;

import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import android.webkit.WebView;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;


import java.io.File;

import java.io.File;

public class VerCausaActivity extends AppCompatActivity {

    //atributo da classe.
    private Button btn_doar;
    private Button btn_voltar;
    private Button btn_divulgar;
    private Button btn_ajuda;
    private AlertDialog alerta;

    private VideoView video;
    private File videosDir;
    ProgressDialog pDialog;
    VideoView videoview;
    WebView mWebView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ver_causa);
        videoview = (VideoView) findViewById(R.id.videoView);


        try {
            // Start the MediaController
            MediaController mediacontroller = new MediaController(
                    VerCausaActivity.this);
            mediacontroller.setAnchorView(videoview);
            // Get the URL from String VideoURL
            Uri video = Uri.parse("android.resource://com.example.samsung.linben/raw/pedido");
            videoview.setMediaController(mediacontroller);
            videoview.setVideoURI(video);

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        btn_doar = (Button) findViewById(R.id.botao);
        btn_voltar = (Button) findViewById(R.id.voltarseta);
        btn_ajuda = (Button) findViewById(R.id.ajuda);
        btn_divulgar = (Button) findViewById(R.id.botao2) ;

        btn_doar.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent i = new Intent(VerCausaActivity.this, CriteriosDoacaoActivity.class);
                                            startActivity(i);
                                        }
                                    }
        );
        btn_voltar.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(VerCausaActivity.this, MenuActivity.class);
                                              startActivity(i);
                                          }
                                      }
        );
        btn_ajuda.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent i = new Intent(VerCausaActivity.this, AjudaActivity.class);
                                             startActivity(i);
                                         }
                                     }
        );

        btn_divulgar.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent i = new Intent(VerCausaActivity.this, ApoiarActivity.class);
                                             startActivity(i);
                                         }
                                     }
        );



    }

}