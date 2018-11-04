package com.laioffer.tinnews.database;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.laioffer.tinnews.retrofit.response.News;

//7.5
@Database(entities = {News.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NewsDao newsDao();
}
