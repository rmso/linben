package com.example.samsung.linben.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.samsung.linben.models.Causa;

/**
 * Created by Raquel on 13/12/2017.
 */
@Database(entities = {Causa.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase INSTANCE;

    public static AppDataBase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "causa_db")
                            .build();
        }
        return INSTANCE;
    }

    public abstract CausaDAO itemCausaModel();
}
