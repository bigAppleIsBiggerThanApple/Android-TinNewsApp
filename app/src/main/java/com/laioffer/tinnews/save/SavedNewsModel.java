package com.laioffer.tinnews.save;

import android.annotation.SuppressLint;

import com.laioffer.tinnews.database.AppDatabase;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


import com.laioffer.tinnews.TinApplication;


public class SavedNewsModel implements SavedNewsContract.Model {

    private SavedNewsContract.Presenter presenter;

    private final AppDatabase db;
    SavedNewsModel() {
        db = TinApplication.getDataBase();
    }

    @Override
    public void setPresenter(SavedNewsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @SuppressLint("CheckResult")
    @Override
    public void fetchData() {
        db.newsDao().getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(presenter::loadSavedNews, error -> {
                    System.out.println("error");
                }, () -> {
                    System.out.println("complete");
                });
    }

}

