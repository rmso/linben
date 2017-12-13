package com.example.samsung.linben.models;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.samsung.linben.database.AppDataBase;

import java.util.List;

/**
 * Created by Raquel on 13/12/2017.
 */

public class CausaViewModel extends AndroidViewModel {

    private final LiveData<List<Causa>> itemCausaList;

    private AppDataBase appDatabase;

    public CausaViewModel(@NonNull Application application) {
        super(application);

        appDatabase = AppDataBase.getDatabase(this.getApplication());

        itemCausaList = appDatabase.itemCausaModel().getAllCausaItems();
    }

    public LiveData<List<Causa>> getItemCausaList() {
        return itemCausaList;
    }

    public void addModel(final Causa causa) {
        new addAsyncTask(appDatabase).execute(causa);
    }

    private static class addAsyncTask extends AsyncTask<Causa, Void, Void> {

        private AppDataBase db;

        addAsyncTask(AppDataBase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final Causa... params) {
            db.itemCausaModel().addCausa(params[0]);
            return null;
        }

    }
}
