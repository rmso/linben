package com.example.samsung.linben.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.samsung.linben.R;


/**
 * Created by Raquel on 12/05/2016.
 */
public class InicioActivity extends Activity{
    private RelativeLayout rl;
    private FragmentActivity fa;

    ListaCausaActivity listaCausa = new ListaCausaActivity();

    ListView list;
    String[] itemname ={
            "Mariana",
            "Claádia",
            "Júlio",
            "Nathália",
            "Paulo",
            "Felipe"
    };

    Integer[] imgid ={
            R.drawable.fotoperfilvideo,
            R.drawable.fotohome1,
            R.drawable.fotohome2,
            R.drawable.fotohome3,
            R.drawable.fotohome4,
            R.drawable.fotohome5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_menu);

    }


}
