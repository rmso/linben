package com.example.samsung.linben;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;


/**
 * Created by Raquel on 12/05/2016.
 */
public class InicioActivity extends Activity{
    private RelativeLayout rl;
    private FragmentActivity fa;
    private Button bt_criar;
    private Button bt_ver1;
    private Button bt_ver2;
    private Button bt_ver3;
    private Button bt_ver4;

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

        bt_ver1 = (Button) findViewById(R.id.button2);
        bt_ver2 =  (Button) findViewById(R.id.vermais2);
        bt_ver3 =  (Button) findViewById(R.id.vermais3);
        bt_ver4 =  (Button) findViewById(R.id.vermais4);

        bt_ver1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent i = new Intent(InicioActivity.this, VerCausaActivity.class);
                                           startActivity(i);
                                       }
                                   }
        );

    }


}
