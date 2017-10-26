package com.example.samsung.linben;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ApoiarActivity extends AppCompatActivity {
    private Button btn_concluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apoiar);

        btn_concluir = (Button) findViewById(R.id.concluir);


        btn_concluir.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Toast.makeText(ApoiarActivity.this, "Divulgação Realizada!", Toast.LENGTH_LONG).show();
                                                Intent i = new Intent(ApoiarActivity.this, MenuActivity.class);
                                                startActivity(i);
                                            }
                                        }
        );

    }
}
