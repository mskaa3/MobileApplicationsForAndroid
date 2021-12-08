package com.example.lab5;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {ItemData.class}, version = 1)
public abstract class MyDB extends RoomDatabase {
    public abstract MyDao myDao();
    private static MyDB DB_INSTANCE;
    static synchronized MyDB getDatabase(final Context context) {
        if (DB_INSTANCE == null) {
            DB_INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    MyDB.class,
                    "item_database")
                    .allowMainThreadQueries()
                    .build();
        } return DB_INSTANCE;
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
