package com.laioffer.tinnews.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.laioffer.tinnews.retrofit.response.News;

//7.4
@Dao
public interface NewsDao {

    @Insert
    void insertNews(News news);
}
