package com.example.samsung.linben;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.samsung.linben.entidades.Hemocentro;

/**
 * Created by Raquel on 06/07/2016.
 */
public class HemocentroActivity extends AppCompatActivity {

    private Button btn_verRota;
    private TextView tv_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hemocentro);

        btn_verRota = (Button) findViewById(R.id.btn_ver_rota);
        tv_link = (TextView) findViewById(R.id.tv_link);

        tv_link.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HemocentroActivity.this, WebViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
