package com.example.samsung.linben;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.samsung.linben.database.DataBase;
import com.example.samsung.linben.entidades.Causa;

import java.util.List;


/**
 * Created by Raquel on 12/05/2016.
 */
public class InicioActivity extends Activity{
    private RecyclerView causasRecyclerView;
    private CausaAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private List<Causa> causaList;
    private DataBase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_menu);



        causasRecyclerView = (RecyclerView) findViewById(R.id.recycle_causa);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        causasRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        causasRecyclerView.setLayoutManager(mLayoutManager);

        getCausasBD();

        // specify an adapter (see also next example)
        mAdapter = new CausaAdapter(causaList);
        causasRecyclerView.setAdapter(mAdapter);


    }
    private void getCausasBD() {
        database = new DataBase(InicioActivity.this);
        causaList = database.buscarCausas();
    }


    @Override
    protected void onResume() {
        super.onResume();
        getCausasBD();
        mAdapter.mudarListaAdapter(causaList);
    }



}
