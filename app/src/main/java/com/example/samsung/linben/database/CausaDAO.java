package com.example.samsung.linben.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.samsung.linben.models.Causa;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Raquel on 13/12/2017.
 */
@Dao
public interface CausaDAO {

    @Query("select * from Causa")
    LiveData<List<Causa>> getAllCausaItems();

    @Query("select * from Causa where id = :id")
    Causa getId(String id);

    @Insert(onConflict = REPLACE)
    void addCausa(Causa causa);
}
