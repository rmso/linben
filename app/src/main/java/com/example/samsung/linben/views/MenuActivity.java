package com.example.samsung.linben.views;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.samsung.linben.R;
import com.example.samsung.linben.database.DataBase;
import com.example.samsung.linben.models.Causa;
import com.example.samsung.linben.views.adapters.CausaAdapter;
import com.example.samsung.linben.views.adapters.RecycleViewClickHack;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, RecycleViewClickHack {
    DrawerLayout drawer;
    FloatingActionButton btn_nova_causa;

    RecyclerView rv_causa;

    CausaAdapter causaAdapter;
    List<Causa> causaList;

    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        causaList = new ArrayList<>();

        rv_causa = findViewById(R.id.rv_causa);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_causa.setLayoutManager(linearLayoutManager);

        getCausaFromDB();

        rv_causa.setAdapter(causaAdapter);

        causaAdapter = new CausaAdapter(causaList);
        rv_causa.setAdapter(causaAdapter);
        causaAdapter.setRecycleViewClick(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        btn_nova_causa = findViewById(R.id.btn_nova_causa);

        btn_nova_causa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, CadastroCausaActivity.class);
                startActivity(intent);
            }
        });

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

    private void getCausaFromDB() {
        dataBase = new DataBase(MenuActivity.this);
        causaList = dataBase.buscarTodasCausas();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();
        if (id == R.id.nav_minhas_causas) {

        } else if (id == R.id.nav_hemocentros) {
            if (this.getClass().getSimpleName().equals("HemocentroActivity")) {
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            } else {
                Intent i = new Intent(this, HemocentroActivity.class);
                startActivity(i);
                    }}
        else if (id == R.id.nav_sobre) {
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

    @Override
    protected void onRestart() {
        super.onResume();
        getCausaFromDB();
        causaAdapter.mudarListaAdapter(causaList);
    }

    @Override
    public void onClickListener(int position) {
        dataBase = new DataBase(MenuActivity.this);
        Causa causa = causaList.get(position);
        Intent intent = new Intent(MenuActivity.this, DetalheCausaActivity.class);

        intent.putExtra("position", position);
        intent.putExtra("id", causa.getId());
        intent.putExtra("descricao", causa.getDescricao());
        intent.putExtra("nome", causa.getNome());
        intent.putExtra("tipo_sanguineo", causa.getTipoSanguineo());
        intent.putExtra("tipo_doenca", causa.getTipoDoenca());

        startActivity(intent);
    }

    @Override
    public void onLongClickListener(int position) {

    }
}
