package com.laioffer.tinnews.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.laioffer.tinnews.retrofit.response.News;

import java.util.List;

import io.reactivex.Flowable;

//7.4
@Dao
public interface NewsDao {

    @Insert
    void insertNews(News news);

    @Query("SELECT * FROM news")
    Flowable<List<News>> getAll();


    @Query("DELETE FROM news")
    void deleteAllNews();


}
