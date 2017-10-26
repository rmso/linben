package com.example.samsung.linben;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    private Button bt_ver1;
    private Button bt_ver2;
    private Button bt_ver3;
    private Button bt_ver4;
    private Button bt_criar;

    ListView list;
    String[] itemname ={
            "Mariana",
            "Claúdia",
            "Júlio",
            "Nathália",
            "Fernanda",
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
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bt_ver1 =  (Button) findViewById(R.id.button2);
        bt_ver2 =  (Button) findViewById(R.id.vermais2);
        bt_ver3 =  (Button) findViewById(R.id.vermais3);
        bt_ver4 =  (Button) findViewById(R.id.vermais4);


        bt_ver1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent i = new Intent(MenuActivity.this, VerCausaActivity.class);
                                           startActivity(i);
                                       }
                                   }
        );


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.gotinha) {
            if (this.getClass().getSimpleName().equals("ApeloActivity")) {
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            } else {
                Intent i = new Intent(this, ApeloActivity.class);
                startActivity(i);
            }
            return true;
        }
        else if (id == R.id.wifi){
            //so pra teste back vai ter que mudar depois
            if (this.getClass().getSimpleName().equals("AlertWifiActivity")) {
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            } else {
                Intent i = new Intent(this, AlertWifiActivity.class);
                startActivity(i);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();
        if (id == R.id.nav_minhas_causas) {

        }else if (id == R.id.nav_editar) {
            if (this.getClass().getSimpleName().equals("CadastroGotinhaActivity")) {
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            } else {
                Intent i = new Intent(this, CadastroGotinhaActivity.class);
                startActivity(i);
            }

        } else if (id == R.id.nav_hemocentros) {
            if (this.getClass().getSimpleName().equals("HemocentroActivity")) {
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            } else {
                Intent i = new Intent(this, HemocentroActivity.class);
                startActivity(i);
            }
        } else if (id == R.id.nav_sobre) {
            if (this.getClass().getSimpleName().equals("SobreActivity")) {
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            } else {
                Intent i = new Intent(this, SobreActivity.class);
                startActivity(i);
            }

        }else if (id == R.id.nav_ajuda) {
            if (this.getClass().getSimpleName().equals("AjudaActivity")) {
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            } else {
                Intent i = new Intent(this, AjudaActivity.class);
                startActivity(i);
            }
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
