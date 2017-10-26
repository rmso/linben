package com.example.samsung.linben;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Raquel on 06/07/2016.
 */
public class EnviarActivity extends AppCompatActivity {
    private Button btn_entrar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar);

        btn_entrar= (Button) findViewById(R.id.entrar);

        btn_entrar.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent i = new Intent(EnviarActivity.this, LoginActivity.class);
                                             startActivity(i);
                                         }
                                     }
        );



    }
}
